import { ExpenseTable } from "../../../SearchExpensesPage/components/ExpenseTable";
import { ExpenseModel } from "../../../Model/ExpenseModel"; 
import { MockDataDashboardTable } from "./MockDataDashBoardTable";
import { type } from "../../../Model/ExpenseType"





export const DashBoardTable = () => {
    
    const mockDataExpenseList : ExpenseModel[] = [];

    for (const key in MockDataDashboardTable) {
        mockDataExpenseList.push({
            id: MockDataDashboardTable[key].id,
            name: MockDataDashboardTable[key].name,
            amount: MockDataDashboardTable[key].amount,
            type: MockDataDashboardTable[key].type as type,
            date: new Date(MockDataDashboardTable[key].date),
        })
    }
    
    
    return (
        <div className="card bg-color">
            <div className="d-flex justify-content-between align-items-center">
            <div className="card-header">
                <h4 className="card-title">Most Recent Expenses</h4>
            </div>
            </div>

            <div className="card-body pt-0">
                <div className="table-responsive">
                    <ExpenseTable 
                    expenseList={mockDataExpenseList}
                    dashboard={true}
                    />
                </div>
            </div>
            
        </div>

    )
}