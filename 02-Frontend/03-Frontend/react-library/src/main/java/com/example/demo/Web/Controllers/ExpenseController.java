package com.example.demo.Web.Controllers;

import com.example.demo.Business.Entities.Expense;
import com.example.demo.Business.Services.ExpenseService;
import com.example.demo.Web.DTOs.EntryDTO;
import com.example.demo.Web.DTOs.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping
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


    @GetMapping("/Submit")
    public String showExpenseForm (Model model) {

        Expense expenseInfo =  new Expense();
        model.addAttribute("expenseInfo", expenseInfo);

        List<Expense.TYPE> expenseTypes = Arrays.asList(Expense.TYPE.Bill, Expense.TYPE.Education, Expense.TYPE.Entertainment, Expense.TYPE.Travel);

        model.addAttribute("expenseInfoTypes", expenseTypes);



        return "Home";




    }

    @PostMapping("/Submit")
    public String addUserExpense (@RequestParam @ModelAttribute("expenseInfo") Expense expenseInfo, @RequestParam("expenseInfoType") Expense.TYPE expenseTypes, Model model) {

        EntryDTO.ExpenseEntryDTO entryDTO = new EntryDTO.ExpenseEntryDTO(expenseInfo.getExpenseName(), expenseInfo.getExpenseCost(), expenseInfo.getExpenseType());

        expenseService.addExpense(entryDTO);


        return "redirect:/Home";

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

