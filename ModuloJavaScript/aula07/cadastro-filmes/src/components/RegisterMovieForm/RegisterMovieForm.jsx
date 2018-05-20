import React from 'react'

import Button from '../generic/Button/Button'
import Select from '../generic/Select/Select'
import Input from '../generic/Input/Input'
import Error from '../generic/Error/Error'

import MovieService from '../../Services/MovieService'

export default class RegisterMovieForm extends React.Component{

    constructor(){
        super()
        this.state = this.getInitialState()
        this.handdleChange=this.handdleChange.bind(this)
        this.onSubmit=this.onSubmit.bind(this)
        this.state = this.getInitialState()
    }

    componentDidMount(){
        this.loadCategoryFromAPI()
    }

    getInitialState(){
        return{
            title:'',
            description:'',
            category:'',
            urlImage:'',
            categories: [],
            errorVisibility:false,
            error:''
        }
    }

    loadCategoryFromAPI(){
        this.props.toggleLoading()
        MovieService.getCategories()
        .then((result)=>{
            let categories=result.data
            this.setState({
                category:categories[0].value,
                categories
            })
            this.props.toggleLoading()
        }).catch((error)=>{
            this.handleError(error)
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

    handleError(error){
        this.setState({
            error: error.response.data.error,
            errorVisibility:true
        })
        this.props.toggleLoading()
    }

    onSubmit(e){
        this.props.toggleLoading()
        const movie=this.state
        MovieService.createMovie(movie.title,movie.description,movie.category,movie.urlImage,localStorage.accessToken)
            .then((result)=>{
                this.props.toggleLoading()
                this.props.reload()
                this.props.onChangeScreen()
            }).catch((error)=>{
                this.handleError(error)
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
                    {this.state.errorVisibility? <Error error={this.state.error}/>:undefined}
                    <Button type="button" onClick={this.onSubmit} typeButton="btn-primary" text="Cadastrar"/>
                    <Button type="button" onClick={this.props.onChangeScreen} typeButton="btn-primary" text="Esconder"/>
                </form>
            </div>
        )
    }
}