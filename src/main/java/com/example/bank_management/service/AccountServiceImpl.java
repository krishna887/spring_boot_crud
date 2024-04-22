package com.example.bank_management.service;

import com.example.bank_management.model.Account;
import com.example.bank_management.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl  implements AccountService{
    @Autowired
    AccountRepository repository;
    @Override
    public Account createAccount(Account account) {
        return repository.save(account);
    }

    @Override
    public Account getAccountByAccountNumber(long accountNumber) {

    return repository.findById(accountNumber).orElseThrow(()->new RuntimeException("account doesn't exist for this  accountNumber"));


    }

    @Override
    public List<Account> getAllAccount() {
        return repository.findAll();
    }

    @Override
    public Account withdrawAmount(long accountNumber, double amount) {
     var account= repository.findById(accountNumber).orElseThrow(()->new RuntimeException("account Not found for this account number"));
     account.setBalance(account.getBalance()-amount);
     repository.save(account);
     return account;
    }

    @Override
    public Account depositAmount(long accountNumber, double amount) {
        var account= repository.findById(accountNumber).orElseThrow(()->new RuntimeException("account doesn't exist for this account Number"));
        account.setBalance(account.getBalance()+amount);
        repository.save(account);
        return account;
    }

    @Override
    public void closeAccount(long accountNumber) {
        var account=repository.findById(accountNumber).orElseThrow(()->new RuntimeException("account doesn't exist for this accountNumber"));
        repository.deleteById(accountNumber);

    }
}
