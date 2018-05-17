import React from 'react'

import NoticiaCategoria from '../NoticiaCategoria/NoticiaCategoria'
import NoticiaTitulo from '../NoticiaTitulo/NoticiaTitulo'
import NoticiaDescricao from '../NoticiaDescricao/NoticiaDescricao'
import NoticiaHorario from '../NoticiaHorario/NoticiaHorario'

import './NoticiaContent.css'

export default class NoticiaContent extends React.Component{

    render(){
        return <div className="noticia--content">
            <NoticiaCategoria categoria={this.props.noticia.categoria}/>
            <NoticiaTitulo titulo={this.props.noticia.titulo}/>
            <NoticiaDescricao descricao={this.props.noticia.descricao}/>
            <NoticiaHorario tempo={this.props.noticia.tempo} categoria={this.props.noticia.categoria}/>
        </div>
    }
}