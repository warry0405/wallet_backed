package service;

import model.CurrentSessionUser;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SessionRepository;

import javax.security.auth.login.LoginException;
import java.util.Optional;

@Service
public class CurrentUserSessionServiceImpl implements CurrentUserSessionService {

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public CurrentSessionUser getCurrentUserSession(String key) throws LoginException {
        Optional<CurrentSessionUser> sessionUser = sessionRepository.findByUuid(key);
        if (sessionUser.isEmpty()) {
            throw new LoginException("对话不存在");
        } else {
            return sessionUser.get();
        }
    }

    @Override
    public Integer getCurrentUserSessionId(String key) throws LoginException {
        Optional<CurrentSessionUser> sessionUser = sessionRepository.findByUuid(key);
        if (sessionUser.isEmpty()) {
            throw new LoginException("请先登录");
        } else {
            return sessionUser.get().getId();
        }
    }

    @Override
    public User getSignUpDetails(String key) throws LoginException {
        Optional<CurrentSessionUser> sessionUser = sessionRepository.findByUuid(key);

        if (sessionUser.isEmpty()) {
            throw new LoginException("请先登录");
        } else {
            return sessionUser.get().getUser();
        }
    }
}
