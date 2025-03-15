import React from "react";


export const TableInfo = () => {
    
    
    return (
        <div className="container my-5">
            <div className="row p-4 align items-center border shadow-lg">
                <div className="col-lg-7 p-3">
                    <h1 className="display-4 fw-bold">
                    Interactive Tables.
                    </h1>
                    <p className="lead">
                    Go beyond static spreadsheets and dive deeper into your information.   
                    Gain a deeper understanding of your information and make informed decisions with ease.


                    </p>
                    <div className="d-grid gap-2 justify-content-md-start mb-4 mb-lg-3">
                        <a className="btn main-color btn-lg text-white" href="/search">
                            Click here for your Expense Services
                        </a>
                    </div>
                </div>
                <div className="col-lg-4 offset-lg-1 shadow-lg lost-image2"></div>
            </div>
        </div>
    );
}