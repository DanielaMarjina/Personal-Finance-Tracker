package com.example.finance_tracker;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import org.slf4j.Logger;

@SpringBootApplication
public class FinanceTrackerApplication {

    //private static final Logger logger= LoggerFactory.getLogger(FinanceTrackerApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(FinanceTrackerApplication.class, args);

    }

//    @Bean
//    public CommandLineRunner demo(TransactionRepository repository){
//        return (args )->{
//            Transaction transaction=new Transaction(LocalDate.parse("2026-02-14"),100.5,"Shopping",
//                    "Shein",TransactionType.Expense);
////            logger.info(transaction.toString());
//
//            repository.save(transaction);
//            repository.save(new Transaction(LocalDate.now(), 250.0, "Food", "Supermarket", TransactionType.Expense));
//            repository.save(new Transaction(LocalDate.now(), 500.0, "Salary", "March Salary", TransactionType.Income));
//            repository.findAll().forEach(transaction1 -> logger.info(transaction1.toString()));
//        };
//    }

}
