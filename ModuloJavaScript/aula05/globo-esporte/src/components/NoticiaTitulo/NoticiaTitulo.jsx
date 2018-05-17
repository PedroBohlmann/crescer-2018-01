import React from 'react'

export default class NoticiaTitutlo extends React.Component{

    render(){
        return <div className="noticia--content__titulo">
        {this.props.titulo}
        </div>
    }
}