import React from 'react'

import './NoticiaTitulo.css'

export default class NoticiaTitulo extends React.Component{

    render(){
        return <div className="noticia--content__titulo">
        {this.props.titulo}
        </div>
    }
}