package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import javax.security.auth.login.LoginException;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public void registerUser(User user) throws LoginException {

        if (user.getMobileNo() == null || user.getMobileNo().isEmpty()) {
            throw new LoginException("手机号不能为空");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new LoginException("密码不能为空");
        }

        User existingUser = userRepo.findByMobileNo(user.getMobileNo()).orElse(null);

        if (existingUser != null) {
            throw new LoginException("手机号已注册");
        }

        userRepo.save(user);
    }
}


