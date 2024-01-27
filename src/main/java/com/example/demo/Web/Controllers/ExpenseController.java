package com.example.demo.Web.Controllers;

import com.example.demo.Business.Entities.Expense;
import com.example.demo.Business.Services.ExpenseService;
import com.example.demo.Web.DTOs.EntryDTO;
import com.example.demo.Web.DTOs.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class ExpenseController {


    @Autowired
    ExpenseService expenseService;


    //    Not yet implemented
    @GetMapping("/")
    public String homePage(@RequestParam(required = false, defaultValue = "User") String name, Model model) {

        name = "Lennox";
        model.addAttribute("name", name);


        return "Home";
    }


    @GetMapping("/show-form")
    public String showExpenseForm (Model model) {


        model.addAttribute("Expense", new Expense());

        List<Expense.TYPE> typeList = Arrays.asList(Expense.TYPE.Bill, Expense.TYPE.Education, Expense.TYPE.Travel, Expense.TYPE.Entertainment);

        model.addAttribute("typeList", typeList);



        return "Home";




    }

    @PostMapping("/shpw-form")
    public String addUserExpense (@ModelAttribute("Expense") Expense expenseInfo, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return "Home";
        }

        EntryDTO.ExpenseEntryDTO entryDTO = new EntryDTO.ExpenseEntryDTO(expenseInfo.getExpenseName(), expenseInfo.getExpenseCost(), expenseInfo.getExpenseType());

        expenseService.addExpense(entryDTO);


        return "redirect:/show-form";

    }

    @PostMapping("/expense-list")
    public String searchExpense(@ModelAttribute SearchDTO.ExpenseSearchDTO searchOBJ, Model model) {
        model.addAttribute("expenseSearchModel", expenseService.searchBarFunc(searchOBJ));


        return "Home";

    }


    @GetMapping("/expense-list")
    public String expenseList(Model model) {

        List<Expense> displayResults = expenseService.getExpensesList();
        List<EntryDTO.ExpenseEntryDTO> resultsDTO = new ArrayList<>();


        System.out.println(displayResults);

        model.addAttribute("expenseListModel", displayResults);


        return "Home";
    }




















}

