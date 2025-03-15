export const Footer = () => {
    return (
        <div className="main-color">
            <div className="container d-flex flex-wrap justify-content-between align-items-center py-5 main-color">
                <p className="col-md-4 mb-0 text-white">© Fintrack, Inc</p>
                <ul className="nav navbar-dark col-md-4 justify-content-end">
                    <li className="nav-item">
                        <a href="/home" className="nav-link px-2 text-white">
                        Home
                        </a>
                    </li>
                    <li className="nav-item">
                        <a href="/search" className="nav-link px-2 text-white">
                            Expenses Table
                        </a>

                    </li>
                    <li className="nav-item">
                        <a href="/dashboard" className="nav-link px-2 text-white">
                            Dashboard
                        </a>
                    </li>
                    <li className="nav-item">
                        <a href="/aboutus" className="nav-link px-2 text-white">
                            About Us
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    )
}