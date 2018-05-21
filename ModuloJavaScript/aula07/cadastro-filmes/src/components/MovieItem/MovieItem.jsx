import React from 'react'

import Button from '../generic/Button/Button'

import './MovieItem.css'

export default class MovieItem extends React.Component{
    
    getCategoryText(){
        const categories = this.props.categories
        for(let i=0; i<categories.length;i++){
            if(categories[i].value===this.props.movie.category){
                return categories[i].text
            }
        }
    }

    render(){
        return (
            <div className="card">
                <img className="movie-img" src={this.props.movie.image} alt="Card image cap"/>
                <div className="card-body">
                    <h4 className="card-title">{this.props.movie.title}</h4>
                    <p className="card-text">{this.props.movie.text}</p>
                    <p className="card-text"><small className="text-muted">{this.getCategoryText()}</small></p>
                    <Button type="button" onClick={this.props.onClick} id={this.props.movie.id} text="Deletar" typeButton="btn-danger"/>
                </div>
            </div>
        )
    }
}