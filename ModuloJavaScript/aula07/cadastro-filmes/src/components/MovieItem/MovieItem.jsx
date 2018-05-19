import React from 'react'

import Button from '../generic/Button/Button'

export default class MovieItem extends React.Component{
    
    render(){
        return (
            <div className="card">
                <div className="card-body">
                    <h4 className="card-title">{this.props.movie.title}</h4>
                    <p className="card-text">{this.props.movie.text}</p>
                    <p className="card-text"><small className="text-muted">{this.props.movie.categorie}</small></p>
                    <Button type="button" text="Deletar" typeButton="btn-danger"/>
                </div>
            </div>
        )
    }
}