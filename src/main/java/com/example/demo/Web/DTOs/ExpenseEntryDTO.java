package com.example.demo.Web.DTOs;

import com.example.demo.Business.Entities.Expense;

public class ExpenseEntryDTO {


    private  String name;
    private  double cost;
    private  Expense.TYPE type;


    ExpenseEntryDTO (String name , Double cost  , Expense.TYPE type) {
        this.name = name;
        this.cost = cost;
        this.type = type;

    }

    public ExpenseEntryDTO() {
        this.name = null;
        this.cost = 0d;
        this.type = null;
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    public Expense.TYPE getType() {
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setType(Expense.TYPE type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Name: " + this.name +" \n" +
                "Cost: " + this.cost + "\n" +
                "Type: " + this.type;
    }
}
