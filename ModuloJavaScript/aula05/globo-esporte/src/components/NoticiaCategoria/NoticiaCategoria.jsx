import React from 'react'

import './NoticiaCategoria.css'

export default class NoticiaCategoria extends React.Component{

    render(){
        return <div className="noticia--content__categoria">
        {this.props.categoria}
        </div>
    }
}