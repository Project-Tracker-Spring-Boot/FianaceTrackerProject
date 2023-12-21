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

        expenseRepository.save(new Expense("Test", 0000.0,  "bill"));
        expenseRepository.save(new Expense("Test2",1222.3,"education"));

    }


    @ManyToOne
    @JoinColumn(name = "__User.id")
     public List<Expense> getExpensesList () {
         return expenseRepository.findAll();
     }





     // Add Expense method using the Entry DTO
     public boolean addExpense(EntryDTO.ExpenseEntryDTO entryDTO ) {

       Expense entry = new Expense(entryDTO.name(), entryDTO.cost(), entryDTO.type());
       expenseRepository.save(entry);
       return true;


     }







// Adding the search operation to the Expense Service
    public List<Expense> searchExpense(SearchDTO.ExpenseSearchDTO entry){
       Expense probe = new Expense();
        // code for if user only searched for name of expense
        if (StringUtils.hasText(entry.name())) {
            return expenseRepository.findByNameContainsAllIgnoreCase(entry.name());
        }
        // code for if we are searching for cost of expense
        else if (!(entry.cost() == 0)) {

            return expenseRepository.findByNumber(entry.cost());

        }

        //code for if we are searching for the date of expense

        else if (Objects.nonNull(entry.date())) {
           return  expenseRepository.findByDate( entry.date());
        }

        // code for searching by type
        else if (StringUtils.hasText(entry.type())){
            return expenseRepository.findByNameContainsAllIgnoreCase(entry.type());
        }

        // If nothing is entered then ...
        else {
            return Collections.emptyList();
        }

    }


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
