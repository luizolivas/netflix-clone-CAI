import React from 'react'
import { getMovies } from '../api'
import { useState, useEffect } from 'react'


function Row({title, path}){
  const [movies, setMovies] = React.useState([])

  const fetchMoveis = async (__path) => {
    try{
      const data = await getMovies(__path)

      setMovies(data?.results)
      console.log(data)
    }catch(error){
      console.log(error)
    }
  }

  useEffect( () => {
    fetchMoveis(path)
  })

  return (

    <div className='rowContainer'>
      <h2 className='row-header'>{title} </h2>
      <div className='row-cards'>
          
      </div>
    </div>
  )
}

export default Row