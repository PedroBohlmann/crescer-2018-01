import React from 'react'

import Button from '../generic/Button/Button'
import MovieList from '../MovieList/MovieList'

import './MoviesTab.css'

export default class MovieTab extends React.Component{

    constructor(){
        super()
    }

    //carregar da api aqui 

    movieList(){
        return[
            {
                title:'surubinha',
                text:'texto',
                categorie:'categoria'
            },
            {
                title:'surubinha',
                text:'texto',
                categorie:'categoria'
            },
            {
                title:'surubinha',
                text:'texto',
                categorie:'categoria'
            },
            {
                title:'surubinha',
                text:'texto',
                categorie:'categoria'
            },
            {
                title:'surubinha',
                text:'texto',
                categorie:'categoria'
            },
            {
                title:'surubinha',
                text:'texto',
                categorie:'categoria'
            },
            {
                title:'surubinha',
                text:'texto',
                categorie:'categoria'
            }
        ]
    }

    render(){
        return(
            <div>
                <div className="navbar-moviestab">
                    <p className="title">Filmes</p>
                    <Button type="button" typeButton="btn-outline-light btn-lg" text="Logout"/>
                </div>
                <div className="movietab-body">
                    <MovieList movies={this.movieList()}/>
                </div>
            </div>
        )
    }
}