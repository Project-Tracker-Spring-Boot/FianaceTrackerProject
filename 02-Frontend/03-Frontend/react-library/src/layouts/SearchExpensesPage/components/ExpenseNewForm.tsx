import React from "react"
import { ExpenseModel } from "../../Model/ExpenseModel"
import { useEffect } from "react";

export const ExpenseNewForm = () => {


    return (

        <div className='mt-5 container col-md-8'>
            
            <div className="card">
                <div className="card-header main-color text-white">
                    Add an Expense
                </div>
                <div className="card-body bg-color justify-content-center d-flex">

                            <form className="form-group col-md-6 ml-10 text-center jusitfy-content-center text-center">
                                <div className='mt-3 justify-content-center'>
                                    <label className='form-label text-main-color'>Expense Description</label>
                                    <input type='text' className='form-control' required></input>
                                </div>
                                <div className='mt-3'>
                                    <label className='form-label text-main-color'>Expense Cost</label>
                                    <input type='number' className='form-control' required></input>
                                </div>
                                <div className='mt-3'>
                                    <label className="form-label text-main-color">Type Description</label>
                                    <select className="form-select" aria-label="Type of Expense">
                                        <option selected>Select type of expense</option>
                                        <option value="Bill">Bill</option>
                                        <option value="Education">Education</option>
                                        <option value="Entertainment">Entertainment</option>
                                        <option value="Travel">Travel</option>
                                    </select>
                                </div>
                                <button type='button' className='btn main-color mt-3 text-white'> Add new expense </button>
                            </form>
                        </div>
                    </div>
                </div>
           



    )
}