import React from 'react'

import Button from '../generic/Button/Button'
import MovieList from '../MovieList/MovieList'
import RegisterMovieForm from '../RegisterMovieForm/RegisterMovieForm'
import MovieService from '../../Services/MovieService'
import LoginService from '../../Services/LoginService'
import Error from '../generic/Error/Error'

import './MoviesTab.css'

export default class MovieTab extends React.Component{

    constructor(){
        super()
        this.state={
            createMovieVisibility:true,
            movies:[],
            errorVisibility:false,
            error:'',
            categories:[]
        }
        this.onClickSwitchScreen=this.onClickSwitchScreen.bind(this)
        this.loadMoviesFromAPI=this.loadMoviesFromAPI.bind(this)
        this.onDelete=this.onDelete.bind(this)
        this.onLogout=this.onLogout.bind(this)
    } 

    componentDidMount(){
        this.loadCategoryFromAPI()
        this.loadMoviesFromAPI()
    }

    loadMoviesFromAPI(){
        this.props.toggleLoading()
        MovieService.getMovies(localStorage.accessToken)
            .then((result)=>{
                const movies = result.data.movies
                this.setState({
                    movies
                })
                this.props.toggleLoading()
            }).catch((error)=>{
                this.handleError(error)
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
        this.props.toggleLoading()
        const target = e.target
        MovieService.deleteMovie(target.id,localStorage.accessToken)
            .then((result)=>{
                this.loadMoviesFromAPI()
                this.props.toggleLoading()
            }).catch((error)=>{
                this.handleError(error)
            })
    }

    onLogout(e){
        this.props.toggleLoading()
        LoginService.logout(localStorage.accessToken)
            .then((result)=>{
                this.props.toggleLoading()
                localStorage.accessToken=""
                this.props.redirectTo('LOGIN')
            }).catch((error)=>{
                this.handleError(error)
            })
    }

    handleError(error){
        this.props.toggleLoading()
        this.setState({
            error: error.response.data.error,
            errorVisibility:true
        })
    }

    loadCategoryFromAPI(){
        this.props.toggleLoading()
        MovieService.getCategories()
        .then((result)=>{
            let categories=result.data
            this.setState({
                categories
            })
            this.props.toggleLoading()
        }).catch((error)=>{
            this.handleError(error)
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
                        <MovieList categories={this.state.categories} movies={this.state.movies} onClick={this.onDelete.bind(this)}/>
                        <Button typeButton="btn-success new-movie" id="new-movie" onClick={this.onClickSwitchScreen} text="Cadastrar novo filme"/>
                        {this.state.errorVisibility? <Error error={this.state.error}/>:undefined}
                    </div>
                    :
                <RegisterMovieForm toggleLoading={this.props.toggleLoading} reload={this.loadMoviesFromAPI} onChangeScreen={this.onClickSwitchScreen}/>
                }</div>
            </div>
        )
    }
}