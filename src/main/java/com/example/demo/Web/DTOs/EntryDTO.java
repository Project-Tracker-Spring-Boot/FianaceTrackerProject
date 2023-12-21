package com.example.demo.Web.DTOs;

import java.util.Calendar;
import java.util.Date;

public class EntryDTO {

    // Expense Element DTO  used to transmit data meant for expense ops from front end HTML to Back end java
    public record  ExpenseEntryDTO (String name , double cost  , String type){

        public record typeEntryDTO (String name,  String value) { }
    }




    //  User DTO used to transmit data meant for expense ops from front end HTML to Back end java
    public record UserEntryDTO (String name, double income ) { }

}
