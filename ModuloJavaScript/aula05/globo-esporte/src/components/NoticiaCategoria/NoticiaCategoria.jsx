import React from 'react'

export default class NoticiaCategoria extends React.Component{

    render(){
        return <div className="noticia--content__categoria">
        {this.props.categoria}
        </div>
    }
}