package com.example.finance_tracker.service;

import com.example.finance_tracker.entity.Transaction;
import com.example.finance_tracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Transaction created(@RequestBody Transaction transaction){
        //@RequestBody convertește JSON-ul din cererea POST în obiect Java Transaction
        boolean exists=repository.existsByDescriptionAndDateAndAmount(
                transaction.getDescription(),
                transaction.getDate(),
                transaction.getAmount());
        if(!exists) return repository.save(transaction);

        return transaction;
    }

}
