package com.fintrack.project.expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Integer> {

        @Query(value = "SELECT * FROM Expense s WHERE s.name ILIKE %:keyword% OR s.type LIKE %:keyword%",
            nativeQuery = true)
    List<Expense> findByKeyword (@Param("keyword") String keyword);

    @Modifying
    @Query(value = "DELETE  FROM Expense  WHERE name = ?1",
            nativeQuery = true)
    void  deleteByName ( String name);

    
}
