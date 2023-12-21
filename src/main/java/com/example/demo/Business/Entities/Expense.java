package com.example.demo.Business.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@ComponentScan(" com.example.demo.Business.EntitiesFields")
@Table(name="__Expense")
public non-sealed class Expense extends EntitiesFields {
   private String type;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date date ;




// Default Constructor
   public Expense () {
       super();
       this.name = null;
       this.number = 0;
       this.date = null;
       this.id = null;
   }

   // Constructor with params

    public Expense (String name , double cost , String type) {

       this.name = name;
       this.number = cost;
       this.date = new Date();
       this.type = type;
       this.id = null;
    }



    // Getters and Setters
    public String getExpenseName () {
        return this.name;
    }
    public void setExpenseName (String name) {
        this.name = name;
    }


    public Date getExpenseDate () {
        return this.date;
    }




    public double getExpenseCost () {
        return this.number;
    }

    public void setExpenseCost(double cost) {
        this.number = cost;
    }

   public String getExpenseType() {
       return this.type;
   }

   public void setExpenseType(String type) {
       this.type = type;
   }


   public Long getExpenseId() { return this.id; }

    public Date getDate () {
       return this.date;
    }


    @Override
    public String toString() {
       return "[Name: "+ this.getExpenseName() + " Cost: "+ this.getExpenseCost() + " Type: " + this.getExpenseType() + "]";
    }

}
