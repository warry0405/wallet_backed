package service;

import dto.LoginResponse;
import model.CurrentSessionUser;
import model.Login;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SessionRepository;
import repository.UserRepository;

import javax.security.auth.login.LoginException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepo;             // User 数据库操作

    @Autowired
    private SessionRepository sessionRepository; // Session 数据库操作


    @Override
    public LoginResponse logInAccount(Login loginData) throws LoginException {
        // 1.查找用户
        Optional<User> userOption = userRepo.findByMobileNo(loginData.getMobileNo());
        if (userOption.isEmpty()) {
            throw new LoginException("用户不存在");
        }

        // 2. 获取 User 实体
        User existingUser = userOption.get();

        // 3.验证密码
        if (!existingUser.getPassword().equals(loginData.getPassword())) {
            throw new LoginException("密码错误");
        }

        // 4.检查是否已经登录
        Optional<CurrentSessionUser> sessionOption = sessionRepository.findByUserUserId(existingUser.getUserId());
        if (sessionOption.isPresent()) {
            throw new LoginException("用户已经登录");
        }

        // 5.生成 Session Key
        String sessionKey = RandomString.getRandomString();

        // 6.创建 Session 对象
        CurrentSessionUser currentSessionUser = new CurrentSessionUser();
        currentSessionUser.setId(null); // 数据库自增
        currentSessionUser.setMobileNo(existingUser.getMobileNo());
        currentSessionUser.setUuid(sessionKey);
        currentSessionUser.setUser(existingUser);
        currentSessionUser.setLocalDateTime(LocalDateTime.now());

        // 7.保存 Session
        sessionRepository.save(currentSessionUser);

        // 8.返回登录信息
        return new LoginResponse(existingUser.getUserId(), sessionKey);
    }


    @Override
    public void logOutFromAccount(String key) throws LoginException {

        if (key == null || key.trim().isEmpty()) {
            throw new LoginException("key 不能为空");
        }

        Optional<CurrentSessionUser> sessionOption =
                sessionRepository.findByUuid(key);

        if (sessionOption.isEmpty()) {
            throw new LoginException("用户未登录或 session 不存在");
        }

        sessionRepository.delete(sessionOption.get());
    }
}
