package controller;

import common.Result;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.RegisterServiceImpl;

import javax.security.auth.login.LoginException;

@RestController
public class RegisterController {
    @Autowired
    RegisterServiceImpl registerService;

    @PostMapping("/register")
    public ResponseEntity<Result<Void>> register(@RequestBody User user) {
        try {
            registerService.registerUser(user);
            return ResponseEntity.ok(
                    Result.success("注册成功，请登录", null)
            );
        } catch (LoginException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Result.error(e.getMessage()));
        }
    }

}
