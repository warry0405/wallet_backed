package controller;

import common.Result;
import dto.LoginResponse;
import jakarta.validation.Valid;
import model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.LoginService;

import javax.security.auth.login.LoginException;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Result<LoginResponse>> loginHandler(
            @Valid @RequestBody Login loginData) throws LoginException {

        // 1. 调用 service
        LoginResponse response = loginService.logInAccount(loginData);

        // 2. 统一返回 Result
        return new ResponseEntity<>(
                Result.success("登录成功", response),
                HttpStatus.OK
        );
    }

    @PostMapping("/logout")
    public ResponseEntity<Result<String>> logoutHandler(
            @RequestBody String key) throws LoginException {

        loginService.logOutFromAccount(key);

        return ResponseEntity.ok(
                Result.success("退出成功")
        );
    }

}
