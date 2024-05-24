package com.example.demo.Business.Entities;

import jakarta.persistence.*;
import org.springframework.context.annotation.ComponentScan;

import java.util.Objects;

@Entity
@ComponentScan(" com.example.demo.Business.EntitiesFields")
@Table(name="__User")
public non-sealed class User extends EntitiesFields {



    // User details


    public String password;

   public  String email;

    public String phoneNumber;




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

    public void setUserIncome(double income) {
        this.number = income;
    }


    @Override
    public boolean equals (Object o) {
        if (this == o) return true;

        if (o == null || this.getClass()!= o.getClass()) return false;

        User user  = (User)o;

        return Objects.equals(this.id,user.id) && Objects.equals(this.name, user.name)
                && Objects.equals(this.number, user.number);
    }


    @Override
    public int hashCode () {
        return Objects.hash(this.id,this.name,this.number);
    }


    @Override
    public String toString() {
        return  "User{" +"id=" + id + " ,name=" + this.name + " + Income " + this.number + " }";
    }

}
