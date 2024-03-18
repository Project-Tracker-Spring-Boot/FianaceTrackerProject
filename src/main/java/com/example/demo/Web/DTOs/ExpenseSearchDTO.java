package com.example.demo.Web.DTOs;

import com.example.demo.Business.Entities.Expense;

import java.util.Date;

public class ExpenseSearchDTO {

    String name ;
    Double cost;
    Expense.TYPE type;

    Date date;

    ExpenseSearchDTO () {
        this.name = null;
        this.cost = null;
        this.type = null;
        this.date = null;


    }

    public ExpenseSearchDTO (String name) {
        this.name = name;
    }

    ExpenseSearchDTO (Date date){
        this.date = date;
    }

   public ExpenseSearchDTO (Expense.TYPE type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }

    public Expense.TYPE getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setType(Expense.TYPE type) {
        this.type = type;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
