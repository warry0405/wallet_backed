package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer walletId;

    @NotNull
    private String walletNo;

    @NotNull
    @PositiveOrZero
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "wallet")
    List<BeneficiaryDetail> beneficiaryDetails;

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    public String getWalletNo() {
        return walletNo;
    }

    public void setWalletNo(String walletNo) {
        this.walletNo = walletNo;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BeneficiaryDetail> getBeneficiaryDetails() {
        return beneficiaryDetails;
    }

    public void setBeneficiaryDetails() {
        this.beneficiaryDetails = new ArrayList<>();
    }

    public Wallet(Integer walletId, String walletNo, Double balance, User user, List<BeneficiaryDetail> beneficiaryDetails) {
        this.walletId = walletId;
        this.walletNo = walletNo;
        this.balance = balance;
        this.user = user;
        this.beneficiaryDetails = beneficiaryDetails;
    }

    public Wallet() {
        super();
    }

}
