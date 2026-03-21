package com.example.finance_tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private double amount;
    private String category;
    private String description;
    private String transactionType;

    protected Transaction() {
    }

    public Transaction(LocalDate date, double amount, String category, String description, String transactionType) {
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.transactionType = transactionType;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
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

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Transaction :" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", transactionType='" + transactionType + " .");
    }
}
