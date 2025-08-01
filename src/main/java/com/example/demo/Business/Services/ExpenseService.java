package com.example.demo.Business.Services;

import com.example.demo.Business.Entities.Expense;


import com.example.demo.Business.Repos.ExpenseRepository;
import com.example.demo.Web.DTOs.EntryDTO;
import com.example.demo.Web.DTOs.SearchDTO;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
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
        expenseRepository.save(new Expense("Ben",1222.3,Expense.TYPE.Education));

    }


    @ManyToOne
    @JoinColumn(name = "__User.id")
     public List<Expense> getExpensesList () {
         return expenseRepository.findAll();
     }





     // Add Expense method using the Entry DTO
     public Expense addExpense(EntryDTO.ExpenseEntryDTO entryDTO) {

       Expense entry = new Expense(entryDTO.name(), entryDTO.cost(), entryDTO.type());
       return expenseRepository.save(entry);



     }







// Adding the search operation to the Expense Service



    public List<Expense> searchBarFunc (SearchDTO.ExpenseSearchDTO search) {

        Expense probe = new Expense();

        if (StringUtils.hasText(search.name())) {
            //Specify the fields of interest
            probe.setExpenseName(search.name());
            probe.setExpenseType(search.type());
        }

        // let's wrap the probe

        Example<Expense> example = Example.of(probe,
                ExampleMatcher.matchingAny()
                        .withIgnoreCase()
                        . withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
        );
        return expenseRepository.findAll(example);


    }

}
