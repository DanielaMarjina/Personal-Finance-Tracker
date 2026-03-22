package com.example.finance_tracker;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //clasa raspunde la cereri HTTP
@RequestMapping("/transactions") //cererile vor fi de genul GET/transactions
public class TransactionController {

    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository){
        this.repository=repository; // cand se creeaza controller ul se creeaza o data
        // si repo care e injectat de Spring. Spring face single instance (singleton)
        // pentru controller si repository prin IoC Container.
    }

    //GET-vezi tranzactiile
    @GetMapping
    public List<Transaction> getAll(){
        return repository.findAll();
    }

    //POST- adaugi un nou obiect
    @PostMapping
    public Transaction create(@RequestBody Transaction transaction){
        //@RequestBody convertește JSON-ul din cererea POST în obiect Java Transaction
        boolean exists=repository.existsByDescriptionAndDateAndAmount(
                transaction.getDescription(),
                transaction.getDate(),
                transaction.getAmount());
        if(!exists) return repository.save(transaction);

        return transaction;
    }




}
