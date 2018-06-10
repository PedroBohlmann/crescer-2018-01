import React from 'react'


import { Button } from 'reactstrap';

export default class TrechoLinhaTabela extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.trecho.id}</td>
                <td>{this.props.trecho.origem.cidade} - {this.props.trecho.origem.aeroporto}</td>
                <td>{this.props.trecho.destino.cidade} - {this.props.trecho.destino.aeroporto}</td>
                <td>{this.props.trecho.distanciaTotal}</td>
                <td><Button name={this.props.trecho.id} onClick={this.props.onEdit} color="warning">Editar</Button></td>
                <td><Button name={this.props.trecho.id} onClick={this.props.onDelete} color="danger">Deletar</Button></td>
            </tr>
        )
    }
}