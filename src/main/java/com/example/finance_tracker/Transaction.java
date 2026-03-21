package com.example.finance_tracker;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double amount;
    private String category;
    private String description;
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    protected Transaction() {
    }

    public Transaction(LocalDate date, double amount, String category, String description, TransactionType type) {
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.type = type;
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

    public TransactionType getTransactionType() {
        return type;
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
                ", type='" + type + " .");
    }
}
