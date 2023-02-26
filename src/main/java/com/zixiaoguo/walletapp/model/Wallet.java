package com.zixiaoguo.walletapp.model;

import java.util.UUID;


public class Wallet {


    private final String id;
    private double balance;



    public Wallet() {
        balance = 0;
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", amount=" + balance +
                '}';
    }
}
