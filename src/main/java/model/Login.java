package model;

import jakarta.persistence.*;

@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String mobileNo;

    private String password;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Login(String mobileNo, String password, User user) {
        this.mobileNo = mobileNo;
        this.password = password;
        this.user = user;
    }

    public Login() {
        super();
    }

}
