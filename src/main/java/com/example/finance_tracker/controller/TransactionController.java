package com.example.finance_tracker.controller;
import com.example.finance_tracker.repository.TransactionRepository;
import com.example.finance_tracker.entity.Transaction;
import com.example.finance_tracker.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //clasa raspunde la cereri HTTP
@RequestMapping("/transactions") //cererile vor fi de genul GET/transactions
@CrossOrigin(origins = "http://localhost:3000") //facem legatura cu front ul
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    //    public TransactionController(TransactionRepository repository){
//        this.repository=repository; // cand se creeaza controller ul se creeaza o data
        // si repo care e injectat de Spring. Spring face single instance (singleton)
        // pentru controller si repository prin IoC Container.
//    }

    //GET-vezi tranzactiile
    @GetMapping
    public List<Transaction> getAll(){
        return service.getAllTransactions();
    }

    //POST- adaugi un nou obiect
    @PostMapping
    public Transaction create(@RequestBody Transaction transaction){
        return service.created(transaction);
    }




}
