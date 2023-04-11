import { useState, useEffect } from 'react'
import './App.css'
import {getMovies, categories} from './api'
import Row from "./components/Row"

function App() {

  useEffect( () => {
    
    let movies = getMovies(categories[0].path)

      movies.then((data) => {
        console.log(data);
      })

  } )
  return (
    <div className="App">

      {categories.map( (category) => {
        return <Row key={category.name} title={category.title} path={category.path} />
      })}

    </div>
  )
}

export default App
