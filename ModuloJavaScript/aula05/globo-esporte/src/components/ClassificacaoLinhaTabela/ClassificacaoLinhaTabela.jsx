import React from 'react'

export default class ClassificacaoLinhaTabela extends React.Component{
    render(){
        return <tr className="classificacao--table__tr">
            <td className="classificacao--table__time">
                <b>{this.props.time.posicao}</b> - {this.props.time.time}
            </td>
            <td className="classificacao--table__pontos">
                {this.props.time.pontuacao}
            </td>
        </tr>
    }
}