package com.example.demo.Web.DTOs;

import com.example.demo.Business.Entities.Expense;

import java.util.Calendar;
import java.util.Date;

public class EntryDTO {

    // Expense Element DTO  used to transmit data meant for expense ops from front end HTML to Back end java
    public record  ExpenseEntryDTO (String name , Double cost  , Expense.TYPE type){


    }



    //  User DTO used to transmit data meant for expense ops from front end HTML to Back end java
    public record UserEntryDTO (String name, Double income ) { }

}
