package com.example.demo.Business.Entities;

import jakarta.persistence.*;
import org.springframework.context.annotation.ComponentScan;

@Entity
@ComponentScan(" com.example.demo.Business.EntitiesFields")
@Table(name="__User")
public non-sealed class User extends EntitiesFields {


    // User only field ID  the @GeneratedValue ask spring to auto populate the values



   // User Entity constructor
    public  User() {
        super();
        this.name = null;
        this.number = 0;
        this.id = null;

    }


    // User Entity constructor with params
    public User (String name , double number ) {
        this.name = name;
        this.number = number;
    }





    //Getters and Setters
    public String getUserName () {
        return this.name;
    }
    public void setUserName (String name) {
        this.name = name;
    }


    public Long getUserID () {
        return this.id;
    }

    public void setUserID(Long id) {
        this.id = id;
    }


    public double

 getUserIncome () {
        return this.number;
    }

    public void setUserIncome(double

 income) {
        this.number = income;
    }
}
