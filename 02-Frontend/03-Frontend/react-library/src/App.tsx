import React from 'react';
import { NavBar } from './layouts/NavBarAndFooter/NavBar';

import './App.css';

import { Footer } from './layouts/NavBarAndFooter/Footer';
import { HomePage } from './layouts/HomePage/HomePage';
import { SearchExpensesPage } from './layouts/SearchExpensesPage/SearchExpensesPage';

export const App = () =>  {
  return (
  <div>
    <NavBar /> 
    {/* <HomePage /> */}
    <SearchExpensesPage />
    <Footer />

  </div>
    


  );
}


