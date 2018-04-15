package com.ottenokleshi.bankproject.models.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private TransactionType type;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "target_account_id")
    private Long targetAccountId;

    @Column(name = "summ")
    private Integer summ;

    @Column(name = "time")
    private Timestamp time;

    public Transaction() {
    }

    public Transaction(TransactionType type, Long accountId, Integer summ) {
        this.type = type;
        this.accountId = accountId;
        this.summ = summ;
        long time = new Date().getTime();
        this.time = new Timestamp(time);
    }

    public Transaction(Long accountId, Long targetAccountId, Integer summ) {
        this.type = TransactionType.TRANSFER;
        this.accountId = accountId;
        this.targetAccountId = targetAccountId;
        this.summ = summ;
        long time = new Date().getTime();
        this.time = new Timestamp(time);
    }

    public Long getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Integer getSumm() {
        return summ;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setSumm(Integer summ) {
        this.summ = summ;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("Transaction[id=%d, type='%s',  accountId='%d', summ='%d', time='%s']",
                id, type, accountId, summ, time);
    }

    public Long getTargetAccountId() {
        return targetAccountId;
    }

    public void setTargetAccountId(Long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }
}
