import React, {useEffect, useState} from 'react';

const ExpenseListContainer = () => {
    const [expense, setExpense] = useEffect ([]);

    useEffect = (() => {
        const fetchExpense = async () => {
            const response = await ({method: "GET", path:'./api/expenses'});
            setExpense(response.enitity._embedded.expenses);
        }
        fetchExpense();
    }, []);

    return  <ExpenseListContainer expenses={expense} />;



};
