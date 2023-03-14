package com.demo_bank_v1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_history")
public class Transact {

    @Id
    private int transaction_id;
    private int accountId;
    private String transactionType;
    private double amount;
    private String source;
    private String status;
    private String reasonCode;
    private LocalDateTime create_at;

    public int getTransaction_id() {
        return transaction_id;
    }

    public Transact() {
    }

    public Transact(int accountId, String transactionType, double amount, String source, String status, String reasonCode, LocalDateTime create_at) {
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.source = source;
        this.status = status;
        this.reasonCode = reasonCode;
        this.create_at = create_at;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }
}
