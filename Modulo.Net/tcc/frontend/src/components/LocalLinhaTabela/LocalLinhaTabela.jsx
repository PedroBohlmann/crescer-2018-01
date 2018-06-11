import React from 'react'

import {Button} from "reactstrap";

export default class LocalLinhaTabela extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.local.cidade}</td>
                <td>{this.props.local.aeroporto}</td>
                <td>{this.props.local.latitude}</td>
                <td>{this.props.local.longitude}</td>
                <td><Button name={this.props.local.id} onClick={this.props.onEdit} color="warning">Editar</Button></td>
                <td><Button name={this.props.local.id} onClick={this.props.onDelete} color="danger">Deletar</Button></td>
            </tr>
        )
    }
}