import React from 'react'

export default class NoticiaDescricao extends React.Component{
    
    render(){
        return <div className="noticia--content__descricao">
        {this.props.descricao}
        </div>
    }

}