package com.example.demo.Business.Entities;

import jakarta.persistence.*;

@MappedSuperclass
abstract sealed class EntitiesFields permits User, Expense  {
     protected String name;
     protected double number;

     protected @GeneratedValue @Id Long id;


}
