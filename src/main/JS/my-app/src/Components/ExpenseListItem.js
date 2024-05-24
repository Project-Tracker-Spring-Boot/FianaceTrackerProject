import React , {useState}  from 'react';
import expenseListContainer from './ExpensesListContainer';



function ExpenseListItem (props) {


   
    return (
        <tr>
            <th scope='row'>Name</th>
            <td>TestName </td>
            <th scope='row'>Cost</th>
            <td>TestCost</td>
            <th scope='row'>Type</th>
            <td>TestType</td>
            <th scope='row'>Date</th>
            <td>TestDate</td>
        </tr>
    )



    
}

export default ExpenseListItem;
