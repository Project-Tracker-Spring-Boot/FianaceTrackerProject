import { useState } from "react";
import ExpenseType from "../../Model/ExpenseType";

export const ExpenseTableItem: React.FC<{
    expenseID: number,
    expenseName: string,
    expenseAmount: number,
    expenseDate: Date,
    expenseType: ExpenseType,
    deleteExpense: Function,
    dashboard : boolean
}> = (props) => {



const dashboard : boolean = props.dashboard;


if (dashboard === false ){
    return (
       
        <tr >
            <th scope="row">{props.expenseID}</th>
            <td>{props.expenseName}</td>
            <td>{props.expenseAmount}</td>
            <td>{props.expenseDate.toLocaleDateString()}</td>
            <td>{props.expenseType}</td>
            <td onClick={() => props.deleteExpense()} className='btn btn-secondary color-red'colSpan={2}>X</td>

        </tr>
    );
}   else {
    return (
       
        <tr >
            
            <td scope='row'>{props.expenseName}</td>
            <td>{props.expenseAmount}</td>
            <td>{props.expenseDate.toLocaleDateString()}</td>
            <td>{props.expenseType}</td>
            

        </tr>
    )
}

}