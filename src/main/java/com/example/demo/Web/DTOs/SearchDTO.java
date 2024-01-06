package com.example.demo.Web.DTOs;

import com.example.demo.Business.Entities.Expense;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class SearchDTO {

    // Expense DTO used to transmit data meant for expense ops from front end HTML to Back end java
    public record ExpenseSearchDTO  (String name, Double cost , Date date, Expense.TYPE type){ }



}
