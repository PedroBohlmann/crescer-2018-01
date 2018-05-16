import React from 'react'

import NoticiaCategoria from '../NoticiaCategoria/NoticiaCategoria'
import NoticiaTitulo from '../NoticiaTitulo/NoticiaTitulo'
import NoticiaDescricao from '../NoticiaDescricao/NoticiaDescricao'
import NoticiaHorario from '../NoticiaHorario/NoticiaHorario'

export default class NoticiaContent extends React.Component{

    render(){
        return <div className="noticia--content">
            <NoticiaCategoria/>
            <NoticiaTitulo/>
            <NoticiaDescricao/>
            <NoticiaHorario/>
        </div>
    }
}