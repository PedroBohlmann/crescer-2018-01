import React from 'react'

import ClassificacaoLinhaTabela from '../ClassificacaoLinhaTabela/ClassificacaoLinhaTabela'

export default class ClassificacaoTabela extends React.Component{
    render(){
        return <table className="classificacao-table">
            <thead>
                <tr>
                    <th className="classificacao-table--th">Classificacao</th>
                    <th className="classificacao-table--th">Pontos</th>
                </tr>
            </thead>
            <tbody>
                <ClassificacaoLinhaTabela/>
            </tbody>
        </table>
    }
}