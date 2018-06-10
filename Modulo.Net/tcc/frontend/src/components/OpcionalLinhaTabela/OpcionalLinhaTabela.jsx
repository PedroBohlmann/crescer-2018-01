import React from 'react'

import {Button} from "reactstrap";

export default class OpcionalLinhaTabela extends React.Component{
    render(){
        return (
            <tr>
                <td>{this.props.opcional.id}</td>
                <td>{this.props.opcional.nome}</td>
                <td>{this.props.opcional.descricao}</td>
                <td>{this.props.opcional.valorPorcentagem}</td>
                <td><Button name={this.props.opcional.id} onClick={this.props.onEdit} color="warning">Editar</Button></td>
                <td><Button name={this.props.opcional.id} onClick={this.props.onDelete} color="danger">Deletar</Button></td>
            </tr>
        )
    }
}