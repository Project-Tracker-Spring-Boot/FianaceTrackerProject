import react from "react";

export const AboutUs = () => {
    return (
        <div className="px-4 pt-5 my-5 text-center border-bottom">
            <h1 className="display-4 fw-bold text-body-emphasis">Who are we ?</h1>
            <div className="col-lg-6 mx-auto">
                <p className="lead mb-4"> We are BootCamp graduates from the UK and Nigeria who have developed this finance tracker app to empower people to take control of their finances. 
                This application serves a dual purpose: it has been an invaluable learning tool for us and also offers a crucial service to those struggling to manage their money. 
                By leveraging our diverse backgrounds and expertise, we've created a user-friendly solution to help individuals track their expenses, budget effectively, 
                and achieve financial stability.</p>
                <div className="d-grid gap-2 d-sm-flex justify-content-sm-center mb-5">
        
                    <button type="button" className="btn main-color btn-lg px-4 text-white">Join Us!</button>
                </div>
            </div>
            <div className="overflow-hidden" id="herosBDiv">
                <div className="container px-5">
                    <img src={require('./../../Images/FinanceTrackerImage/Designer.jpeg')} className="rounded-circle shadow-4-strong" alt="Example image" width="700" height="500" loading="lazy"></img>
                </div>
            </div>
        </div>
    )
}   