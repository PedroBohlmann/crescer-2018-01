import React from 'react'

import NoticiaItem from '../NoticiaItem/NoticiaItem'
import './Noticias.css'

export default class Noticias extends React.Component{

    renderTodasNoticias(){
        return this.props.noticias.map((noticiaAtual,index)=>{
            return <NoticiaItem key={index} noticia={noticiaAtual}/>
        })
    }

    render(){
        return <div className="noticia">
            {this.renderTodasNoticias()}
        </div>
    }
}