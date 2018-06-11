import React from 'react'

import {Button} from "reactstrap";

export default class ReservaLinhaTabela extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.reserva.trecho.origem.cidade}, {this.props.reserva.trecho.origem.aeroporto}->
                    {this.props.reserva.trecho.destino.cidade}, {this.props.reserva.trecho.destino.aeroporto}
                </td>
                <td>R${this.props.reserva.valorTotal}</td>
                <td><Button name={this.props.reserva.id} onClick={this.props.onDelete} color="danger">Deletar</Button></td>
            </tr>
        )
    }
}