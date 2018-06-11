import React from 'react'

import {Input} from "reactstrap";

export default class OpcionaisLinhaTabelaSimplificada extends React.Component{
    render(){
        return (
            <tr>
                <td>{this.props.opcional.nome}</td>
                <td>{this.props.opcional.descricao}</td>
                <td>{this.props.opcional.valorPorcentagem*100}%</td>
                <td><Input id={this.props.opcional.id} name="opcionaisList" type="checkbox" onChange={this.props.onChange}/></td>
            </tr>
        )
    }
}