package com.example.finance_tracker.repository;

import com.example.finance_tracker.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    //are metodele ei de baza cusave, findAll care le implementeaza

    //daca vreau sa adaug functia mea o scriu dupa un anumit format care poate fi descifrat in sql
    // de ex List<Transaction> findByAmount(double amount)
    //ar fi Select * from Transactions Where amount=?

    boolean existsByDescriptionAndDateAndAmount(String description, LocalDate date, double amount);
}
