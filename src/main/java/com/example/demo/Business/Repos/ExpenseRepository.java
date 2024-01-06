package com.example.demo.Business.Repos;

import com.example.demo.Business.Entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository <Expense , Long>  {

    public List<Expense>findByNameContainsAllIgnoreCase(String name);

    public List<Expense> findByNumber (Double number);

    public List<Expense> findByDate(Date date);



}
