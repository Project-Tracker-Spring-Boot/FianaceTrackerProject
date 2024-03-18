package com.example.demo.Business.Repos;

import com.example.demo.Business.Entities.Expense;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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




    @Query(value = "SELECT * FROM Expense p WHERE (:example IS NULL OR p.name LIKE :exampleName)",
                nativeQuery = true)
    List<Expense> findByExample(@Param("example") Example<Expense> example);


    @Query(value = "SELECT * FROM __Expense s WHERE s.name LIKE %:keyword% OR s.type LIKE %:keyword%",
            nativeQuery = true)
    List <Expense> findByKeyword (@Param("keyword") String keyword);


    List <Expense> findByType(Expense.TYPE type);



}
