package service;

import model.User;

import javax.security.auth.login.LoginException;

public interface RegisterService {
    public void registerUser(User user) throws LoginException;
}
