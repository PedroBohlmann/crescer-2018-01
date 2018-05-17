import React from 'react'

import './NoticiaHorario.css'

export default class NoticiaHorario extends React.Component{

    render(){
        return <div className="noticia--content__horario">
        HÁ {this.props.tempo} - {this.props.categoria}
        </div>
    }
}