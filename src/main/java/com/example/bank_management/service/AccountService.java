package com.example.bank_management.service;

import com.example.bank_management.model.Account;

import java.util.List;


public interface AccountService {
     Account createAccount(Account account);
     Account getAccountByAccountNumber(long accountNumber);
      List<Account> getAllAccount();
      Account withdrawAmount(long accountNumber, double amount);
      Account depositAmount(long accountNumber, double amount);
       void closeAccount(long accountNumber);

}
