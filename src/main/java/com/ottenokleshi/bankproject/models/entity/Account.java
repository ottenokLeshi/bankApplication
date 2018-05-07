package com.ottenokleshi.bankproject.models.entity;

import com.ottenokleshi.bankproject.models.validators.ContactBalanceConstraint;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "client_id")
    private Long clientId;

    @ContactBalanceConstraint
    @Column(name = "balance")
    private Integer balance;

    public Account() {
    }

    public Account(Long clientId) {
        this.clientId = clientId;
        this.balance = 0;
    }

    public Account(Long clientId, Integer balance) {
        this.clientId = clientId;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public Long getClientId() {
        return clientId;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Client[id=%d, clientId='%s', balance='%s']", id, clientId, balance);
    }
}
