import React from 'react'

import {Button} from "reactstrap";

export default class LocalLinhaTabela extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.usuario.cidade}</td>
                <td>{this.props.usuario.aeroporto}</td>
                <td>{this.props.usuario.latitude}</td>
                <td>{this.props.usuario.longitude}</td>
                <td><Button name={this.props.usuario.id} onClick={this.props.onEdit} color="warning">Editar</Button></td>
                <td><Button name={this.props.usuario.id} onClick={this.props.onDelete} color="danger">Deletar</Button></td>
            </tr>
        )
    }
}