package com.example.bank_management.controller;

import com.example.bank_management.model.Account;
import com.example.bank_management.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService service;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        var created_account = service.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(created_account);
    }

    @GetMapping("/{id}")
        public Account getAccountByAccountNumber(@PathVariable Long id){
           return service.getAccountByAccountNumber(id) ;
        }
        @GetMapping("/getall")
    public List<Account> getAllAccount(){
        return service.getAllAccount();
        }
        @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdraw(@PathVariable Long accountNumber, @PathVariable Double amount){
        return service.withdrawAmount(accountNumber,amount);

        }
    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account deposit(@PathVariable Long accountNumber, @PathVariable Double amount){
        return service.depositAmount(accountNumber,amount);

    }
    @PostMapping("delete/{accountNumber}")
    public  ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber){
      service.closeAccount(accountNumber);
       return ResponseEntity.status(HttpStatus.ACCEPTED).body("account close");
    }

}
