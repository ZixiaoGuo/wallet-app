package com.zixiaoguo.walletapp.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionHistory {

    private double initialBalance;
    private List<Double> history;
    private double currentBalance;

    public TransactionHistory() {
        history = new ArrayList<>();
        initialBalance = 0;
        currentBalance = initialBalance;
    }

    public TransactionHistory(double initialBalance) {
        history = new ArrayList<>();
        this.initialBalance = initialBalance;
        currentBalance = initialBalance;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public List<Double> getHistory() {
        return history;
    }

    public void setHistory(List<Double> history) {
        this.history = history;
    }


    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void addRecord(double changeValue) {
        history.add(changeValue);
        currentBalance += changeValue;
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "initialBalance=" + initialBalance +
                ", history=" + history +
                ", currentBalance=" + currentBalance +
                '}';
    }
}
