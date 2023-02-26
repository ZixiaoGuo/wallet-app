package com.zixiaoguo.walletapp.controller;

import com.zixiaoguo.walletapp.model.TransactionHistory;
import com.zixiaoguo.walletapp.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    private Wallet wallet;
    private TransactionHistory transactionHistory;

    @Autowired
    public WalletController(TransactionHistory transactionHistory) {
        wallet = new Wallet();
        //this.repository = repository;
        this.transactionHistory = transactionHistory;
    }

    @GetMapping
    public double checkAmount() {
        return wallet.getBalance();
    }

    @PostMapping("/refund/{amount}")
    public Wallet refund(@PathVariable double amount) {
        var balance = wallet.getBalance();
        wallet.setBalance(balance + amount);
        transactionHistory.addRecord(amount);
        return wallet;
    }

    @PostMapping("/pay/{amount}")
    public Wallet pay(@PathVariable double amount) {
        var balance = wallet.getBalance();
        wallet.setBalance(balance - amount);
        transactionHistory.addRecord(-amount);
        return wallet;
    }

    @GetMapping("/history")
    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }
}
