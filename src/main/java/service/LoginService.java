package service;

import dto.LoginResponse;
import model.Login;

import javax.security.auth.login.LoginException;

public interface LoginService {
    public LoginResponse logInAccount(Login loginData) throws LoginException;

    public void logOutFromAccount(String key) throws LoginException;
}
