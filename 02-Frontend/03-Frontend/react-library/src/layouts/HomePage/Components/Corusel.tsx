import { ReturnBook } from "./ReturnBook"
import { useEffect , useState } from 'react';
import { ExpenseModel } from './../../Model/ExpenseModel'
import React from "react";      
import { SpinnerLoading } from "../../Utils/SpinnerLoading";
export const Carousel = () => {

    // This represents the expense object that will be displayed hence why the generic is declared as an expenseModel []
    const [expense, setExpense ] = useState<ExpenseModel[]>([]);
    // Display a loading sign if our api is still loading as fetch is asynchrous and therefore might be a time delay
    const [isLoading, setIsLoading ] = useState(true);
    // Check and display a http error sign if there is an error in making the fetch request 
    const [httpError, setHttpError] = useState(null);

    useEffect(() => {
        const fetchExpense = async () => {
            const baseUrl: string = 'http://localhost:8080/expenses';
            const url: string = `${baseUrl}?page=0&size=20`; // ?page=0&size=20
            const response = await fetch(url);

            //Way to check if we successful got the data 
            if (!response.ok) {
                throw new Error('Something went wrong!');
            }

            //Change the data gotten from the fetch to json 
            const responseJson = await response.json();
            const responseData = responseJson._embedded.expenses;

            // Storing the response (data) in an array 
            const loadedExpense: ExpenseModel[] = [];
            for (const key in responseData) {
                loadedExpense.push({
                    id: responseData[key].id,
                    name: responseData[key].name,
                    amount: responseData[key].amount,
                    type: responseData[key].type,
                    date: responseData[key].date
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
    }, []);

    if (isLoading) {
        return (
            <SpinnerLoading />
        )
    }

    if (httpError) {
        return (
            <div className="container m-5">
                <p>{httpError}</p>
            </div>
        )
    }
    return (
        <div className="container mt-5" style={{ height: 550 }}>
            <div className="homepage-carousel-title">
                <h3>Find your next "I stayed up too late reading" book.</h3>
            </div>
            <div id='carouselExampleControls' className="carousel carousel-dark slide mt-5
            d-none d-lg-block" dat-bs-interval='false'>

                {/* Desktop */}
                <div className='carousel-inner'>
                    <div className='carousel-item active'>
                        <div className="row d-flex justify-content-center align-items-center">
                          {
                            expense.slice(0,3).map(expense => (
                                <ReturnBook expense={expense} key={expense.id} />
                            ))
                          }
                        </div>
                    </div>

                    <div className='carousel-item'>
                        <div className="row d-flex justify-content-center align-items-center">
                        {
                            expense.slice(3,6).map(expense => (
                                <ReturnBook expense={expense} key={expense.id} />
                            ))
                          }
                        </div>
                    </div>

                    <div className='carousel-item'>
                        <div className="row d-flex justify-content-center align-items-center">
                        {
                            expense.slice(6,9).map(expense => (
                                <ReturnBook expense={expense} key={expense.id} />
                            ))
                          }
                        </div>
                    </div>

                </div>


                <button className='carousel-control-prev' type='button'
                    data-bs-target='#carouselExampleControls' data-bs-slide='prev'>
                    <span className='carousel-control-prev-icon' aria-hidden='true'></span>
                    <span className='visually-hidden'>Previous</span>
                </button>

                <button className='carousel-control-next' type='button'
                    data-bs-target='#carouselExampleControls' data-bs-slide='next'>
                    <span className='carousel-control-next-icon' aria-hidden='true'></span>
                    <span className='visually-hidden'>Next</span>
                </button>
            </div>


            {/* Mobile */}

            <div className='d-lg-none mt-3'>
                <div className='row d-flex justify-content-center align-items-center'>
                    <ReturnBook expense={expense[0]} key={expense[0].id} />
                </div>
                <div className="homepage-carousel-title mt-3">
                    <a className='btn btn-outline-secondary btn-lg' href="#">View More</a>
                </div>
            </div>

        </div>

    )
}