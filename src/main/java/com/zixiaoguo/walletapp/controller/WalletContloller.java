package com.zixiaoguo.walletapp.controller;

import com.zixiaoguo.walletapp.model.TransactionHistory;
import com.zixiaoguo.walletapp.model.Wallet;
import com.zixiaoguo.walletapp.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wallet")
public class WalletContloller {

    private Wallet wallet;
    private final WalletRepository repository;
    private TransactionHistory transactionHistory;

    @Autowired
    public WalletContloller(Wallet wallet, WalletRepository repository, TransactionHistory transactionHistory) {
        this.wallet = wallet;
        this.repository = repository;
        this.transactionHistory = transactionHistory;
    }

    @GetMapping
    public double checkAmount() {
        return wallet.getAmount();
    }

    @PostMapping("/refund20")
    public void refund20() {
        var amount = wallet.getAmount();
        wallet.setAmount(amount + 20);
        transactionHistory.addRecord(20);
    }

    @PostMapping("/consume100")
    public void consume100() {
        var amount = wallet.getAmount();
        wallet.setAmount(amount - 100);
        transactionHistory.addRecord(-100);
    }

    @GetMapping("/history")
    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }
}
