import React from "react";
import { ExpenseModel } from "../../Model/ExpenseModel";
import ExpenseType from "../../Model/ExpenseType";
import { useState, useEffect} from "react";
import { ExpenseTableItem } from "./ExpenseTableItem";

export const ExpenseTable: React.FC<{expenseList: ExpenseModel[] , dashboard : boolean }> = (props) => {
   
   
   const expenseList : ExpenseModel[] = props.expenseList;

   const deleteExpense : Function = () => {
    return true;
   };
   
   
   return (

        


            <table className="color-primary table table-hover table-striped sm" >
                <thead>
                    <tr>
                        {!props.dashboard ? (<th className="col">#</th>) : null}
                        <th className="col">Name</th>
                        <th className="col">Amount</th>
                        <th className="col">Date</th>
                        <th className="col">Type</th>
                        {!props.dashboard ? (<th className="col"></th>) : null}
                    </tr>
                </thead>
                <tbody>
                    

                   {expenseList.map(expense => (
                            <ExpenseTableItem 
                            key = {expense.id}
                            expenseID = {expense.id}
                            expenseName = {expense.name}
                            expenseAmount = {expense.amount}
                            expenseDate = {expense.date}
                            expenseType = {expense.type}
                            deleteExpense = {deleteExpense}
                            dashboard = {props.dashboard}
                             />
                        ))}
                        
        

                </tbody>

            
            </table>
            

       

    );
        
}