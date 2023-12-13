package com.example.demo.Business.Entities;

import jakarta.persistence.*;
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
    private Timestamp date;




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
       this.date = new Timestamp(date.getTime());
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




    public double

 getExpenseCost () {
        return this.number;
    }

    public void setExpenseCost(double

 cost) {
        this.number = cost;
    }

   public String getExpenseType() {
       return this.type;
   }

   public void  setExpenseType(String type) {
       this.type = type;
   }


   public Long getExpenseId() { return this.id; }

    public Timestamp getDate () {
       return this.date;
    }

}
