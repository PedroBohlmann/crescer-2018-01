import React from 'react'

import NoticiaItem from '../NoticiaItem/NoticiaItem'

export default class Noticias extends React.Component{

    renderTodasNoticias(){
        return this.props.noticias.map((noticiaAtual)=>{
            return <NoticiaItem noticia={noticiaAtual}/>
        })
    }

    render(){
        return <div className="noticia">
            {this.renderTodasNoticias()}
        </div>
    }
}