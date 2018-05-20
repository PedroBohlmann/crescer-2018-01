import React from 'react'

import Button from '../generic/Button/Button'
import Select from '../generic/Select/Select'
import Input from '../generic/Input/Input'

import MovieService from '../../Services/MovieService'

export default class RegisterMovieForm extends React.Component{

    constructor(){
        super()
        this.state = this.getInitialState()
        this.handdleChange=this.handdleChange.bind(this)
        this.onSubmit=this.onSubmit.bind(this)
        this.state = this.getInitialState()
        this.loadCategoryFromAPI()
    }

    getInitialState(){
        return{
            title:'',
            description:'',
            category:'',
            urlImage:'',
            categories: []
        }
    }

    loadCategoryFromAPI(){
        MovieService.getCategories()
        .then((result)=>{
            let categories=result.data
            this.setState({
                categories
            })
        }).catch((error)=>{
            console.log(error)
        })
    }

    handdleChange(event) {
        const target = event.target
        const value = target.value
        const name = target.name
        this.setState({
            [name]: value
        })
    }

    onSubmit(e){
        const movie=this.state
        MovieService.createMovie(movie.title,movie.description,movie.category,movie.urlImage,localStorage.accessToken)
            .then((result)=>{
                console.log(result)
            }).catch((error)=>{
                console.log(error)
            })
    }

    render(){
        return(
            <div className="d-flex justify-content-center">
                <form>
                    <h1 className="display-4">Cadastrar filme</h1>
                    <Input type="text"  onChange={this.handdleChange} placeholder="Titulo do filme" name="title" id="title" label="Title"/>
                    <Input type="text" onChange={this.handdleChange} placeholder="Descrição do filme" name="description" id="description" label="Descrição"/>
                    <Input type="text" onChange={this.handdleChange} placeholder="URL para a imagem" name="urlImage" id="urlImage" label="URL para a imagem"/>
                    <Select label="Categoria" options={this.state.categories} handdleChange={this.handdleChange} name="category" id="category"/>
                    <Button type="button" onClick={this.onSubmit} typeButton="btn-primary" text="Cadastrar"/>
                    <Button type="button" onClick={this.props.onChangeScreen} typeButton="btn-primary" text="Esconder"/>
                </form>
            </div>
        )
    }
}