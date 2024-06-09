package com.fintrack.project.expense;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ExpenseRequest {

    private  String name;
    private   double cost;
    private Expense.TYPE type;
}
