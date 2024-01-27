package com.example.demo.Business.Entities;

import com.example.demo.Business.Repos.ExpenseRepository;
import com.example.demo.Business.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {


    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;


    @Autowired
    public DatabaseLoader (ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }



    @Override
    public void run(String... strings) throws Exception {
        this.expenseRepository.save(new Expense("Ben",1222.3,Expense.TYPE.Education));
    }
}
