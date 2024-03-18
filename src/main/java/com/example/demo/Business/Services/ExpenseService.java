package com.example.demo.Business.Services;

import com.example.demo.Business.Entities.Expense;


import com.example.demo.Business.Repos.ExpenseRepository;
import com.example.demo.Web.DTOs.ExpenseEntryDTO;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;


@Service
public class ExpenseService {



@Autowired private final ExpenseRepository expenseRepository;



@Autowired public ExpenseService (ExpenseRepository expenseRepository) {
     this.expenseRepository = expenseRepository;

    }


    @PostConstruct
    public void initDatabase () {
        System.out.println(" DB init recognized ");

        expenseRepository.save(new Expense("Test", 0000.0, Expense.TYPE.Bill));


    }


    @ManyToOne
    @JoinColumn(name = "__User.id")
     public List<Expense> getExpensesList () {
         return expenseRepository.findAll();
     }





     // Add Expense method using the Entry DTO

    @ManyToOne
    public Expense addExpense(ExpenseEntryDTO entryDTO) {

       Expense entry = new Expense(entryDTO.getName(), entryDTO.getCost(), entryDTO.getType());
       return expenseRepository.save(entry);



     }


     public void removeExpense (Long expenseID ) {

        expenseRepository.findById(expenseID)
                .map(expense -> {
                    expenseRepository.delete(expense);
                    return true;
                }).orElseThrow(() -> new RuntimeException("Expense could not be deleted " + expenseID));

     }







// Adding the search operation to the Expense Service



    public List<Expense> getByKeyword (String keyword ) {

        return expenseRepository.findByKeyword(keyword);
    }


    public List<Expense> getAllExpenses () {
        return expenseRepository.findAll();
    }


}
