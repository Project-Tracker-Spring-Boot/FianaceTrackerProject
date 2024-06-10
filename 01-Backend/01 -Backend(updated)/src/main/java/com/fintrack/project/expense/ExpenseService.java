package com.fintrack.project.expense;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@AllArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;


    public Expense addExpense(ExpenseRequest expenseRequest) {

        var expense = Expense.builder()
                .name(expenseRequest.getName())
                .amount(expenseRequest.getCost())
                .type(expenseRequest.getType())
                .build();
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses () {

        return expenseRepository.findAll();
    }

    public List<Expense> getByKeyword (String keyword ) {

        return expenseRepository.findByKeyword(keyword);
    }

    @Transactional
    public void deleteExpense(String name) {

        expenseRepository.deleteByName(name);
    }
}
