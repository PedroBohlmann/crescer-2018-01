import React from 'react'

import Button from '../generic/Button/Button'
import MovieList from '../MovieList/MovieList'
import RegisterMovieForm from '../RegisterMovieForm/RegisterMovieForm'

import './MoviesTab.css'

export default class MovieTab extends React.Component{

    constructor(){
        super()
        this.state={
            createMovieVisibility:true,
            movies:[]
        }
        this.onClickSwitchScreen=this.onClickSwitchScreen.bind(this)
    } 

    loadMoviesFromAPI(){

    }

    movieList(){
        return this.state.movies
    }

    onClickSwitchScreen(e){
        let visibility = !this.state.createMovieVisibility
        this.setState({
            createMovieVisibility:visibility
        })
    }

    getCreateMovieVisibility(){
        return this.state.createMovieVisibility
    }

    render(){
        return(
            <div>
                <div className="navbar-moviestab">
                    <p className="title">Filmes</p>
                    <Button type="button" typeButton="btn-outline-light btn-lg logout" text="Logout"/>
                </div>
                <div className="movietab-body container-fluid mt-3">
                {this.getCreateMovieVisibility()?
                   <div>
                        <MovieList movies={this.movieList()}/>
                        <Button typeButton="btn-success new-movie" id="new-movie" onClick={this.onClickSwitchScreen} text="Cadastrar novo filme"/>
                    </div>
                    :
                    <RegisterMovieForm onChangeScreen={this.onClickSwitchScreen}/>
                }</div>
            </div>
        )
    }
}