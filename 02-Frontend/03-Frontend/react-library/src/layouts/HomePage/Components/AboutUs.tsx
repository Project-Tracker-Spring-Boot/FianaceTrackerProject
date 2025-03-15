export const AboutUs = () => {
    return (
        <div className="container my-5">
            <div className="row p-4 align items-center border shadow-lg">
                <div className="col-lg-7 p-3">
                    <h1 className="display-4 fw-bold">
                    Easy-to-Read <br></br>Dashboards.
                    </h1>
                    <p className="lead">
                    Stop wondering where your money disappears! 
                    See Where Your Money Goes with Easy-to-Read Dashboards. 
                    Our interactive platform breaks down your spending habits with clear visuals, 
                    making it effortless to identify areas to save and improve your financial well-being. 
                    Take control of your finances today!


                    </p>
                    <div className="d-grid gap-2 justify-content-md-start mb-4 mb-lg-3">
                        <a className="btn main-color btn-lg text-white" href="/dashboard">
                            Click here for your Dashboard Service
                        </a>
                    </div>
                </div>
                <div className="col-lg-4 offset-lg-1 shadow-lg lost-image"></div>
            </div>
        </div>
    )
}