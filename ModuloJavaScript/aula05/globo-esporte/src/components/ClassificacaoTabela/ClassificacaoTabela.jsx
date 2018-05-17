import React from 'react'

import ClassificacaoLinhaTabela from '../ClassificacaoLinhaTabela/ClassificacaoLinhaTabela'

export default class ClassificacaoTabela extends React.Component{

    renderTodosTimes(){
        return this.props.times.map((timeAtual)=>{
            return <ClassificacaoLinhaTabela time={timeAtual}/>
        })
    }

    render(){
        return <table className="classificacao-table">
            <thead>
                <tr>
                    <th className="classificacao-table--th">Classificacao</th>
                    <th className="classificacao-table--th">Pontos</th>
                </tr>
            </thead>
            <tbody>
                {this.renderTodosTimes()}
            </tbody>
        </table>
    }
}