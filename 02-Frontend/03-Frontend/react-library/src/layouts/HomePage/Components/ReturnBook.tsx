import React from 'react'
import { ExpenseModel } from '../../Model/ExpenseModel';

export const ReturnBook : React.FC<{expense: ExpenseModel}> = (props) => {
    return(

        <div className = "col-xs-6 col-sm-6 col-md-4 col-lg-3 mb-3" >
            <div className='text-center'>
                {props.expense.type ?
                    <p>{props.expense.type}</p>
                : <p>No Type mentioned </p>
                }

                <img src={require('./../../../Images/BooksImages/book-luv2code-1000.png')}
                    width='151'
                    height='233'
                    alt="book1" />
                <h6 className="mt-2">{props.expense.name}</h6>
                <p>{props.expense.amount}</p>
                <a className='btn main-color text-white' href="#">Reserve</a>

            </div>
        </div>       



    );
}