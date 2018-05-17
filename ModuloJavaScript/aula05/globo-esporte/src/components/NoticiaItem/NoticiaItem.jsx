import React from 'react'

import NoticiaContent from '../NoticiaContent/NoticiaContent'

export default class NoticiaItem extends React.Component{
    render(){
        return  (
            <div className="noticia--item">
                <div className="noticia--imagem">
                        <img className="noticia--imagem__img" src={this.props.noticia.imagem}
                        />
                </div>
                <NoticiaContent noticia={this.props.noticia}/>
            </div>
        )
    }
}