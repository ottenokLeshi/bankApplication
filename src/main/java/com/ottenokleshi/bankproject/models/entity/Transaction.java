package com.ottenokleshi.bankproject.models.entity;


import javax.persistence.*;
import java.io.Serializable;
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

    @Column(name = "accountid")
    private Long accountId;

    @Column(name = "summ")
    private Integer summ;

    @Column(name = "time")
    private Date time;

    private Transaction() {
    }

    public Transaction(TransactionType type, Long accountId, Integer summ ) {
        this.type = type;
        this.accountId = accountId;
        this.summ = summ;
        this.time = new Date();
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

    public Date getTime() {
        return time;
    }
    @Override
    public String toString() {
        return String.format("Transaction[id=%d, type='%s', summ='%d', time='%s']", id, type, summ, time);
    }
}
