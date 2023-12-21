package com.example.demo.Web.Controllers;

import com.example.demo.Business.Entities.Expense;
import com.example.demo.Business.Entities.User;
import com.example.demo.Business.Services.ExpenseService;
import com.example.demo.Web.DTOs.EntryDTO;
import com.example.demo.Web.DTOs.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {


    @Autowired
    ExpenseService expenseService;


    @Autowired
    HomeController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    //    Not yet implemented
    @GetMapping("/")
    public String homePage(@RequestParam(required = false, defaultValue = "User") String name, Model model) {

        name = "Lennox";
        model.addAttribute("name", name);


        return "Home";
    }


    @GetMapping("/expense-list")
    public String expenseList(Model model) {

        List<Expense> displayResults = expenseService.getExpensesList();
        List<EntryDTO.ExpenseEntryDTO> resultsDTO = new ArrayList<>();
//
//        for (Expense result : displayResults) {
//            resultsDTO.add(new EntryDTO.ExpenseEntryDTO(result.getExpenseName(), result.getExpenseCost(),result.getExpenseType()));
//        }

        System.out.println(displayResults);

        model.addAttribute("expenseListModel", displayResults);


        return "Home";
    }


    @PostMapping("/expense-list")
    public String getPerson(@ModelAttribute SearchDTO.ExpenseSearchDTO searchOBJ, Model model) {
        model.addAttribute("expenseSearchModel", expenseService.searchBarFunc(searchOBJ));


        return "Home";


    }

    @PostMapping("/")
    public String addUserExpense (@RequestParam("type") String type , @RequestParam EntryDTO.ExpenseEntryDTO entryDTO, Model model) {

        EntryDTO.ExpenseEntryDTO entry = new EntryDTO.ExpenseEntryDTO(entryDTO.name(), entryDTO.cost(), type);



        model.addAttribute("add-entry", expenseService.addExpense(entry));

        return "Home";

    }

}

