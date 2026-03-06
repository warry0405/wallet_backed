package service;

import model.CurrentSessionUser;
import model.User;

import javax.security.auth.login.LoginException;

public interface CurrentUserSessionService {
    public CurrentSessionUser getCurrentUserSession(String key) throws LoginException;

    public Integer getCurrentUserSessionId(String key) throws LoginException;

    public User getSignUpDetails(String key) throws LoginException;
}
