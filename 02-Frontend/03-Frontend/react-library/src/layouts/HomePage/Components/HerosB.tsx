import React from 'react';

export const HerosB = () => {
    return (
        <div className="px-4 pt-5 my-5 text-center border-bottom">
            <h1 className="display-4 fw-bold text-body-emphasis">Your AI Finance Partner</h1>
            <div className="col-lg-6 mx-auto">
                <p className="lead mb-4"> Fintrack makes expense tracking effortless, giving you the insights you need to take charge of your finances.  By simply signing up to 
                our secure platform automatically tracks your spending, 
                categorizes it all for you, and gives you a crystal clear view of where your money goes. 
                It's the first step to making smarter financial decisions, 
                reaching your goals faster, and leveling up your financial future!</p>
                <div className="d-grid gap-2 d-sm-flex justify-content-sm-center mb-5">
                    <button type="button" className="btn main-color btn-lg px-4 me-sm-3 text-white">Sign In</button>
                    <button type="button" className="btn main-color btn-lg px-4 text-white">Sign Up</button>
                </div>
            </div>
            <div className="overflow-hidden" id="herosBDiv">
                <div className="container px-5">
                    <img src={require('./../../../Images/FinanceTrackerImage/Designer.jpeg')} className="img-fluid border rounded-3 shadow-lg mb-4" alt="Example image" width="700" height="500" loading="lazy"></img>
                </div>
            </div>
        </div>
    );
}