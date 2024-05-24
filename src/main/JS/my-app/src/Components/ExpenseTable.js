import React from 'react'
import ExpenseListItem from './ExpenseListItem';

function ExpenseTable (props) {


return (
    <table>
        <thead>
            <tr scope='row'>
                <th>Name</th>
                <th>Amount</th>
                <th>Date</th>
                <th>Type</th>

            </tr>
        </thead>
        <tbody>
            <ExpenseListItem />
        </tbody>
    </table>
)

}
export default  ExpenseTable;