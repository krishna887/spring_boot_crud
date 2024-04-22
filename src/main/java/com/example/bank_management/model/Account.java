package com.example.bank_management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
            @Column(name = "account_number")
    long accountNumber;
    @Column(name = "account_name")
    String accountName;
    double balance;

    public Account() {

    }
    public Account(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
