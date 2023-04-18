import React, {useEffect, useState} from  'react'
import categories, { getMovies } from '../api';
import './Banner.css'


function Banner() {

    const [movies, setMovies] = React.useState({})



    
    const fetchRandomMovies = async (_path) => {
        try{
 
         const netflixOriginalsCategory = categories.find((category) =>     
             (category.name === "netflixOriginals"))
         
             const data = await getMovies(netflixOriginalsCategory.path)
             const randomIndex = Math.floor(Math.random * data.results.length)
             const movies = data?.results  
             setMovies(movies[ramdomIndex])   
 
        }catch(error) {
         console.log('error Banner.js: ', error)
        }
 
     }


    useEffect( () => {

        fetchRandomMovies(path)

    }, [] )


    return (
        <div>
            Banner
        </div>
    )

}

export default Banner;