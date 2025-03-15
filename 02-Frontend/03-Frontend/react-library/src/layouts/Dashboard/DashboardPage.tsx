import { Sidebar } from "./components/Sidebar/Sidebar"
import {BarChart } from "./components/BarChart/BarChart";
import { MockDataBarChart  } from "./components/BarChart/MockDataBarChart"
import {PieChart } from "./components/PieChart/PieChart"
import { MockDataPieChart } from "./components/PieChart/MockDataPieChart";
import { MockDataChordChart } from "./components/ChordChart/MockDataChordChart";
import { ChordChart } from "./components/ChordChart/ChordChart";
import { DashBoardTable } from "./components/DashBoardTable/DashBoardTable";
import { Cards } from './components/Cards/Cards';
 




export const DashboardPage = () => {



    return (
    <div className='container-fluid mt-4 mb-4'>
      <div className="row">
        <div className="col-2">
          <nav className="navbar bg-tertiary ">
            <div className="container-fluid">
              <a className="navbar-brand" style={{color:"black"}} href="#"><h3>Dashboard</h3></a>
            </div>

          </nav>
        </div>
      </div>
      
      <Cards />
      

      <div className="col h-100 m-3">
      <BarChart data={MockDataBarChart} /> 
      </div>

      <div className="row">
        <div className="col ">
        <PieChart data={MockDataPieChart} />
        </div>

        <div className="col ">
        <ChordChart  data={MockDataChordChart}/>
        </div>
      </div>

      <div className="row m-4"> 
        <DashBoardTable />
      </div>
  

    

      




    </div>
  );
};





