import React from 'react'

import ClassificacaoCabecalho from '../ClassificacaoCabecalho/ClassificacaoCabecalho'
import ClassificacaoCabecalhoSecundario from '../ClassificacaoCabecalhoSecundario/ClassificacaoCabecalhoSecundario'
import ClassificacaoTabela from '../ClassificacaoTabela/ClassificacaoTabela'

export default class Classificao extends React.Component{

    render(){
        return <div className="classificacao">
            <ClassificacaoCabecalho/>
            <ClassificacaoCabecalhoSecundario/>
            <ClassificacaoTabela times={this.props.times}/>
        </div>
    }
}