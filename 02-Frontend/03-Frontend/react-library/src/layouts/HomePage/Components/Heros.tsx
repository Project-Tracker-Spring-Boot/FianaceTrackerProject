export const Heros = () => {
    return (
        <div>
            <div className='d-none d-lg-block'>
                <div className='row g-0 mt-5'>
                    <div className='col-sm-6 col-md-6'>
                        <div className="col-image-left"></div>
                    </div>

                    <div className="col-4 col-md-4 container d-flex justify-content-center align-items-center">
                        <div className="ml-2">
                            <h1>Unleash the Power of AI for Smarter Spending and Financial Freedom</h1>
                            <p className="lead">
                            Tired of spreadsheets and endless calculations?  Fintrack puts the power of Artificial Intelligence in your hands to take control of your finances. 
                             Our innovative platform helps you effortlessly track expenses and get personalized financial advice.
                            </p>
                           
                        </div>
                    </div>
                </div>
                <div className="row g-0">
                    <div className="col-4 col-md-4 container d-flex justify-content-center align-items-center">
                        <div className="ml-2">
                            <h1>Gain valuable insights,  make informed decisions!</h1>
                            <p className="lead">
                            Our AI tool analyzes your spending habits, highlighting areas to optimize,
                            Identify hidden spending patterns and discover opportunities to save. 
                            Feel confident and empowered with every financial decision you make.
                            </p>
                        </div>
                    </div>
                    <div className="col-sm-6 col-md-6">
                        <div className="col-image-right"></div>
                    </div>
                </div>
            </div>

            {/* Mobile Heros */}
            <div className="d-lg-none">
                <div className="container">
                    <div className="m-2">
                        <div className="col-image-left"></div>
                        <div className="mt-2">
                        <h1>Unleash the Power of AI for Smarter Spending and Financial Freedom</h1>
                            <p className="lead">
                                Tired of spreadsheets and endless calculations?  
                                Fintrack puts the power of Artificial Intelligence in your hands to take control of your finances. 
                                Our innovative platform helps you effortlessly track expenses and get personalized financial advice.
                            </p>
                            
                        </div>
                    </div>
                    <div className="m-2">
                        <div className="col-image-right">

                        </div>
                        <div className="mt-2">
                        <h1>Gain valuable insights,  make informed decisions!</h1>
                            <p className="lead">
                           Our AI tool analyzes your spending habits, highlighting areas to optimize, 
                            Identify hidden spending patterns and discover opportunities to save. 
                            Feel confident and empowered with every financial decision you make.
                            </p>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    );
}