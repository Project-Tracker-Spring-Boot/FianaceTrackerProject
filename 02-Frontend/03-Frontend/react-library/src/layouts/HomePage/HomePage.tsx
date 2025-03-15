
import { Carousel } from "./Components/Corusel"
import { ExploreTopBooks } from "./Components/ExploreTopBooks"
import { Heros } from "./Components/Heros"
import { AboutUs } from "./Components/AboutUs"
import { HerosB } from "./Components/HerosB"
import { TableInfo } from "./Components/TableInfo"

export const HomePage = () => {
    return (
        <>
            
            <ExploreTopBooks />
            <HerosB />
            <Heros />
            <AboutUs />
            <TableInfo />
        

        </>
    )
}