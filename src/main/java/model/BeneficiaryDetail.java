package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class BeneficiaryDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer beneficiaryId;

    @NotNull
    private String name;

    @NotNull
    @Pattern(regexp = "1[3-9]\\d{9}")
    private String mobileNo;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public Integer getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Integer beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public BeneficiaryDetail(Integer beneficiaryId, String name, String mobileNo, Wallet wallet) {
        this.beneficiaryId = beneficiaryId;
        this.name = name;
        this.mobileNo = mobileNo;
        this.wallet = wallet;
    }

    public BeneficiaryDetail() {
        super();
    }
}
