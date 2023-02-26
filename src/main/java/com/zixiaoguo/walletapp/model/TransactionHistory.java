package com.zixiaoguo.walletapp.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionHistory {
    List<Double> history;

    public TransactionHistory() {
        history = new ArrayList<Double>();
    }

    public List<Double> getHistory() {
        return history;
    }

    public void setHistory(List<Double> history) {
        this.history = history;
    }

    public void addRecord(double changeValue) {
        history.add(changeValue);
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "TransactionHistory=" + history +
                '}';
    }
}
