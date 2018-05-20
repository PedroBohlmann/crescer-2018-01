import React from 'react'

import MovieItem from '../MovieItem/MovieItem' 

export default class MovieList extends React.Component{
    
    renderMovies(){
        return this.props.movies.map((movie,index)=>{
            return  <MovieItem key={index} movie={movie} onClick={this.props.onClick}/> 
        })
    }

    render(){
        return <div>{this.renderMovies()}</div>
    }
}