package com.example.demo.Web.Controllers;

import com.example.demo.Business.Entities.Expense;
import com.example.demo.Business.Services.ExpenseService;
import com.example.demo.Web.DTOs.ExpenseEntryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ExpenseListController {

    @Autowired
    private final ExpenseService expenseService;


    public ExpenseListController (ExpenseService expenseService) {
        this.expenseService = expenseService;
    }


    @RequestMapping("/search")
    public String ExpeneseTable(ExpenseEntryDTO expense, Model model, String keyword) {

        System.out.println(keyword);
        if (keyword != null) {
            List<Expense> list = expenseService.getByKeyword(keyword);
            model.addAttribute("list", list);
            System.out.println(list);
        } else {
            List<Expense> list =  expenseService.getAllExpenses();
            model.addAttribute("list", list);
            System.out.println(list);
        }
        model.addAttribute("EntryExpenseDTO", new ExpenseEntryDTO());
        return "Home";
    }







}
