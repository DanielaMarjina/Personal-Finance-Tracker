package com.example.finance_tracker;

import jdk.jfr.Enabled;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Enabled
public class Transaction {
    private AtomicInteger id;
    private LocalDate date;
    private double value;
    private String category;
    private String description;
    private String transactionType;

    protected Transaction() {
    }

    public Transaction(LocalDate date, double value, String category, String description, String transactionType) {
        this.date = date;
        this.value = value;
        this.category = category;
        this.description = description;
        this.transactionType = transactionType;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public AtomicInteger getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Transaction :" +
                "id=" + id +
                ", date=" + date +
                ", value=" + value +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", transactionType='" + transactionType + " .");
    }
}
