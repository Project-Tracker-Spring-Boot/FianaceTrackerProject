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
   private TYPE type;
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

    public Expense (String name , Double cost , TYPE type) {

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




    public Double getExpenseCost () {
        return this.number;
    }

    public void setExpenseCost(Double cost) {
        this.number = cost;
    }

   public TYPE getExpenseType() {
       return this.type;
   }

   public void setExpenseType(Expense.TYPE type) {
       this.type = type;
   }


   public Long getExpenseId() { return this.id; }

    public Date getDate () {
       return this.date;
    }


    public enum TYPE {

        Bill {
            @Override
            public String toString(){return "Bill"; }
        }, Entertainment {
            @Override
            public String toString () {return "Entertainment";}
        }, Education{
            @Override
            public String toString() { return "Education" ;}
        }, Travel {
            @Override
            public String toString () { return  "Travel"; }
        }

    }


    @Override
    public String toString() {
       return "[Name: "+ this.getExpenseName() + " Cost: "+ this.getExpenseCost() + " Type: " + this.getExpenseType() + "]";
    }

}
