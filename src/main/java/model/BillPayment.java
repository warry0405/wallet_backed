package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class BillPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer billId;

    @NotNull
    @DecimalMin(value = "0.1", inclusive = true)
    private Double amount;

    private LocalDateTime time;

    @Enumerated(EnumType.STRING)
    private BillType billType;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public Integer getBillId() {
        return billId;
    }
    public void setBillId(Integer billId) {
        this.billId = billId;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public BillType getBillType() {
        return billType;
    }
    public void setBillType(BillType billType) {
        this.billType = billType;
    }
    public TransactionType getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
    public Wallet getWallet() {
        return wallet;
    }
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public BillPayment(Integer billId, Double amount, LocalDateTime time, BillType billType,TransactionType transactionType, Wallet wallet) {
        this.billId = billId;
        this.amount = amount;
        this.time = time;
        this.billType = billType;
        this.transactionType = transactionType;
        this.wallet = wallet;
    }

    public BillPayment() {
        super();
    }
}
