package com.example.demo.Web.Controllers;

import com.example.demo.Business.Entities.Expense;
import com.example.demo.Business.Services.ExpenseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.jackson.util.CharTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
public class ChartController {

    ExpenseService expenseService;

    @Autowired
    ChartController (ExpenseService expenseService) {
        this.expenseService = expenseService;
    }


    @GetMapping("/charts")
    public String getChart(Model model) {
        // Fetch your data here, e.g., List<DataPoint> dataPoints = getDataPoints();

        HashMap<String, Integer> dataPoints = expenseService.getChartData();

        // Turn Hash map into JSON data
        String jsonData = null;
        try {
            jsonData = new ObjectMapper().writeValueAsString(dataPoints);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        // Add JSON to model
        model.addAttribute("dataPoints", jsonData);





        return "Charts";
    }




}
