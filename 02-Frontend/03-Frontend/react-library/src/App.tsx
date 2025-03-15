import React from 'react';
import { NavBar } from './layouts/NavBarAndFooter/NavBar';

import './App.css';

import { Footer } from './layouts/NavBarAndFooter/Footer';
import { HomePage } from './layouts/HomePage/HomePage';
import { SearchExpensesPage } from './layouts/SearchExpensesPage/SearchExpensesPage';
import { Redirect, Route, Switch } from "react-router-dom";
import { DashboardPage } from './layouts/Dashboard/DashboardPage';
import { AboutUs } from './layouts/AboutUs/AboutUs';


export const App = () => {
  return (
    <div>
      <NavBar />
      <Switch>
        <Route path="/" exact>
          <Redirect to="/home" />
        </Route>

          <Route path="/home">
          <HomePage />
          <Footer />
           
          </Route>
       
        <Route path="/search" exact >
          <SearchExpensesPage />
          <Footer />
        </Route>

        <Route path="/dashboard" exact>
          
          <DashboardPage />
          <Footer />
        </Route>

        <Route path="/aboutus" exact>
          <AboutUs />
          <Footer />
        </Route>
      </Switch>
      

      

    </div>


  );
}


