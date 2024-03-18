package com.example.demo.Web.Controllers;

import com.example.demo.Business.Entities.Expense;
import com.example.demo.Business.Services.ExpenseService;


import com.example.demo.Web.DTOs.ExpenseEntryDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AddExpenseController {


    @Autowired
    private final ExpenseService expenseService;



    @Autowired
    AddExpenseController(ExpenseService expenseService ) {
        this.expenseService = expenseService;
    }


    //    Not yet implemented



    @GetMapping("/")
    public String showExpenseForm (Model model) {

        model.addAttribute("EntryExpenseDTO", new ExpenseEntryDTO());

        return "Home";

    }

    @PostMapping("/")
    public String addUserExpense (@ModelAttribute("EntryExpenseDTO") ExpenseEntryDTO expenseEntryDTO , Model model) {

        expenseService.addExpense(expenseEntryDTO);
        model.addAttribute("EntryExpenseDTO", new ExpenseEntryDTO());

        System.out.println(expenseEntryDTO);


        return "redirect:/";

    }






























}

