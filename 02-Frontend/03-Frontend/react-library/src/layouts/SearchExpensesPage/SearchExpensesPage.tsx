import { useEffect, useState } from "react";
import { ExpenseModel } from "../Model/ExpenseModel";
import { SpinnerLoading } from "../Utils/SpinnerLoading";
import { SearchExpense } from "./components/SearchExpense";
import { Pagination } from "../Utils/Pagination";
import { Route, Switch, Redirect } from "react-router-dom";
import { ExpenseTable } from "./components/ExpenseTable";
import { ExpenseNewForm } from "./components/ExpenseNewForm";


export const SearchExpensesPage = () => {

    // This represents the expense object that will be displayed hence why the generic is declared as an expenseModel []
    const [expense, setExpense] = useState<ExpenseModel[]>([]);
    // Display a loading sign if our api is still loading as fetch is asynchrous and therefore might be a time delay
    const [isLoading, setIsLoading] = useState(true);
    // Check and display a http error sign if there is an error in making the fetch request 
    const [httpError, setHttpError] = useState(null);

    const [currentPage, setCurrentPage] = useState(1);
    const [expensePerPage] = useState(10);

    const [totalAmountExpenses, setTotalAmountExpenses] = useState(0);

    const [totalPages, setTotalPages] = useState(2);
    const [responseCode, setResponseCode] = useState(200);
    const [showAddTodoForm, setShowAddTodoForm] = useState(false);



    useEffect(() => {
        const fetchExpense = async () => {
            const baseUrl: string = 'http://localhost:8080/expenses';
            const url: string = `${baseUrl}?page=${currentPage - 1}&size=${expensePerPage}`; // ?page=0&size=20
            const response = await fetch(url);

            //Way to check if we successful got the data 
            if (!response.ok) {

                setResponseCode(response.status)
                throw new Error('Something went wrong!');

            }

            //Change the data gotten from the fetch to json 
            const responseJson = await response.json();
            const responseData = responseJson._embedded.expenses;

            setTotalAmountExpenses(responseJson.page.totalELements);
            setTotalPages(responseJson.page.totalPage);

            // Storing the response (data) in an array 
            const loadedExpense: ExpenseModel[] = [];
            for (const key in responseData) {
                loadedExpense.push({
                    id: responseData[key].id,
                    name: responseData[key].name,
                    amount: responseData[key].amount,
                    type: responseData[key].type,
                    date: new Date(responseData[key].date)
                });

            }
            setExpense(loadedExpense);
            setIsLoading(false);
        };
        fetchExpense().catch((error: any) => {
            setIsLoading(false);
            setHttpError(error.message);

        })
        // The second parameter of the useEffect checks if there is a chang in state since this is empty this indicates that the data gotten will be static for the book tutorial that i am using this for 
        // however this will change when adding  dynamic data from the expense api to a table 
        window.scrollTo(0, 0);
    }, [currentPage]);



    if (isLoading) {
        return (
            <SpinnerLoading />
        )
    }

    if (httpError) {

        switch (responseCode) {
            case 403:
                return (

                    <div className="container m-5">
                        <Switch>
                            <Route path='/search'>
                                <Redirect to='/home' />


                            </Route>

                        </Switch>
                    </div>
                )
            default:
                return (
                    <div className="container m-5">
                        <p>{httpError}</p>

                    </div>
                )
        }


    }

    const indexOfLastExpense: number = currentPage * expensePerPage;
    const indexOfFirstExpense: number = indexOfLastExpense - expensePerPage;
    const lastItem = expensePerPage * currentPage <= totalAmountExpenses ?
        expensePerPage * currentPage : totalAmountExpenses;

    const paginate = (pageNumber: number) => setCurrentPage(pageNumber);

    return (
        <div>
            <div className="container">

                <div className="row mt-5">
                    <div className="col-6">
                        <div className="d-flex">
                            <input className="form-control me-2" type="search"
                                placeholder="Search" aria-aria-label="Search" />
                            <button className=" btn btn-outline-success">
                                Search
                            </button>
                        </div>
                    </div>
                    <div className="col-4">
                        <div className="dropdown">
                            <button className="btn btn-secondary dropdown-toggle" type="button"
                                id="dropdownMenuButton1" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                Category
                            </button>
                            <ul className="dropdown-menu" aria-aria-labelledby="dropdownMenuButton1">
                                <li>
                                    <a className="dropdown-item" href="#">
                                        All
                                    </a>
                                </li>
                                
                                <li>
                                    <a className="dropdown-item" href="#">
                                        Bill
                                    </a>
                                </li>
                                <li>
                                    <a className="dropdown-item" href="#">
                                        Entertainment
                                    </a>
                                </li>
                                <li>
                                    <a className="dropdown-item" href="#">
                                        Education
                                    </a>
                                </li>
                                <li>
                                    <a className="dropdown-item" href="#">
                                        Travel
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div className="mt-3">
                        <h5>Number of results: ({totalAmountExpenses}) </h5>
                    </div>
                    <p>
                        {indexOfFirstExpense + 1} to {lastItem} of {totalAmountExpenses} items:
                    </p>
                    {/* {expense.map (expense => (
                        <SearchExpense expense={expense} key={expense.id} />

                    ))} */}

                    <ExpenseTable 
                    expenseList={expense} 
                    dashboard={false}
                    />
                    {totalPages > 1 &&
                        <Pagination currentPage={currentPage} totalPage={totalPages} paginate={paginate} />
                    }

                    <div className="col-14 justify-content-center mt-3 mb-3 position-relative text-center">
                    <button onClick={() => setShowAddTodoForm(!showAddTodoForm)} className='btn main-color text-white btn-large ml-5 active'>{showAddTodoForm ? 'Close New Expense' : 'New Expense'}</button>
                    {showAddTodoForm && <ExpenseNewForm />}

                    </div>


                   


                </div>
            </div>

        </div>
    );
}