import React from 'react'

import Button from '../generic/Button/Button'
import MovieList from '../MovieList/MovieList'
import RegisterMovieForm from '../RegisterMovieForm/RegisterMovieForm'
import MovieService from '../../Services/MovieService'
import LoginService from '../../Services/LoginService'

import './MoviesTab.css'

export default class MovieTab extends React.Component{

    constructor(){
        super()
        this.state={
            createMovieVisibility:true,
            movies:[]
        }
        this.onClickSwitchScreen=this.onClickSwitchScreen.bind(this)
        this.loadMoviesFromAPI=this.loadMoviesFromAPI.bind(this)
        this.onDelete=this.onDelete.bind(this)
        this.onLogout=this.onLogout.bind(this)
        this.loadMoviesFromAPI()
    } 

    loadMoviesFromAPI(){
        MovieService.getMovies(localStorage.accessToken)
            .then((result)=>{
                const movies = result.data.movies
                this.setState({
                    movies
                })
            }).catch((error)=>{
                console.log(error)
            })
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

    onDelete(e){
        const target = e.target
        MovieService.deleteMovie(target.id,localStorage.accessToken)
            .then((result)=>{
                this.loadMoviesFromAPI()
            }).catch((error)=>{
                console.log(error)
            })
    }

    onLogout(e){
        LoginService.logout(localStorage.accessToken)
            .then((result)=>{
                localStorage.accessToken=""
                this.props.redirectTo('LOGIN')
            }).catch((error)=>{
                console.log(error)
            })
    }

    render(){
        return(
            <div className="div-body">
                <div className="navbar-moviestab">
                    <p className="title">Filmes</p>
                    <Button type="button" onClick={this.onLogout} typeButton="btn-outline-light btn-lg logout" text="Logout"/>
                </div>
                <div className="movietab-body">
                {this.getCreateMovieVisibility()?
                   <div>
                        <MovieList movies={this.state.movies} onClick={this.onDelete.bind(this)}/>
                        <Button typeButton="btn-success new-movie" id="new-movie" onClick={this.onClickSwitchScreen} text="Cadastrar novo filme"/>
                    </div>
                    :
                <RegisterMovieForm reload={this.loadMoviesFromAPI} onChangeScreen={this.onClickSwitchScreen}/>
                }</div>
            </div>
        )
    }
}