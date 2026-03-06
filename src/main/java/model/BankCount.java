package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.annotations.Parent;

@Entity
public class BankCount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer accountNumber;

    @NotNull
    @PositiveOrZero
    private Double balance;

    @NotNull
    private String ifscCode;

    @NotNull
    private String bankName;

    @NotNull
    @Pattern(regexp = "1[3-9]\\d{9}")
    private String mobileNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BankCount(Integer accountNumber, Double balance, String ifscCode, String bankName, String mobileNumber, User user) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ifscCode = ifscCode;
        this.bankName = bankName;
        this.mobileNumber = mobileNumber;
        this.user = user;
    }

    public BankCount() {
        super();
    }
}
