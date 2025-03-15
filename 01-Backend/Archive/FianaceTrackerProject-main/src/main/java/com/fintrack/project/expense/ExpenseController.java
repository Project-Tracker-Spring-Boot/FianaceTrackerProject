package com.fintrack.project.expense;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("_expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping("/")
    public String showExpenseForm (Model model) {

        model.addAttribute("EntryExpenseDTO", new ExpenseRequest());

        return "Home";

    }

    @PostMapping("/create-expense")
    public String addUserExpense (@ModelAttribute("EntryExpenseDTO") ExpenseRequest expenseRequest , Model model) {

        expenseService.addExpense(expenseRequest);
        model.addAttribute("EntryExpenseDTO", new ExpenseRequest());




        return "redirect:/";

    }

    @RequestMapping("/search")
    public String ExpenseTable(ExpenseRequest expense, Model model, String keyword) {

        System.out.println(keyword);
        if (keyword != null) {
            List<Expense> list = expenseService.getByKeyword(keyword);
            model.addAttribute("list", list);
            System.out.println(list);
        } else {
            List<Expense> list = expenseService.getAllExpenses();
            model.addAttribute("list", list);
            System.out.println(list);
        }
        model.addAttribute("EntryExpenseDTO", new ExpenseRequest());
        return "Home";
    }
    @DeleteMapping("/Delete/{name}")
    public String deleteByName(@PathVariable("name") String name){
        expenseService.deleteExpense(name);
        return "redirect:/Home";
    }








}
