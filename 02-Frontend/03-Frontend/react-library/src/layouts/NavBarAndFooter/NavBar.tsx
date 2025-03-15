import {useState } from "react";

export const NavBar = () => {

    const [isLoggedIn , setIsLoggedIn ] = useState(false);

    const clickHandlerLogIn = () => {
        isLoggedIn ? setIsLoggedIn(false) : setIsLoggedIn(true);
    }
    return (
        <nav className='navbar navbar-expand-lg navbar-dark main-color py-3'>
            <div className='container-fluid'>
                <span className='navbar-brand'>Fintrack</span>
                <button className='navbar-toggler' type="button"
                    data-bs-toggle='collapse' data-bs-target='#navbarNavDropdown'
                    aria-controls='navbarNavDropdown' aria-expanded='false'
                    aria-label='Toggle navigation'>
                    <span className='navbar-toggler-icon'></span>
                </button>

                <div className='collapse navbar-collapse' id='navbarNavDropdown'>
                    <ul className='navbar-nav '>
                        <li className='nav-item'>
                            <a className='nav-link' href="/home">Home</a>
                        </li>
                        <li className='nav-item'>
                            <a className='nav-link' href="/dashboard">DashBoard</a>
                        </li>
                        <li className='nav-item'>
                            <a className='nav-link' href="/search">Expenses Table</a>
                            </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/aboutus">About Us</a>
                        </li>
                    </ul>

                    {!isLoggedIn ? (
                         <ul className='navbar-nav ms-auto'>
                         <li className='nav-item m-1'>
                             <a type='button' className='btn btn-outline-light' onClick={clickHandlerLogIn}>Sign in</a>
                         </li>
                         <li className="nav-item m-1">
                             <a type="button" className="btn btn-outline-light" href="#">Sign Up</a>
                         </li>
 
                     </ul>) :
                     (
                        <div className="navbar-nav ms-auto">
                            <a href="#"><img src={require("../../Images/BooksImages/new-book-1.png")}></img></a>
                        </div>
                     )}
                   
                </div>

            </div>

        </nav>
    )
}
export default NavBar;