package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer userId;

    @NotNull
    private String userNo;

    @NotNull
    private String userName;

    @NotNull
    @Pattern(regexp = "1[3-9]\\d{9}")
    private String mobileNo;

    @NotNull
    @JsonIgnore
    @Size(min = 6, max = 12)
    private String password;

    @NotNull
    @Email
    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public User(Integer userId, String userName, String mobileNo, String password, String email) {
        this.userId = userId;
        this.userName = userName;
        this.mobileNo = mobileNo;
        this.password = password;
        this.email = email;
    }

    public User() {
        super();
    }
}
