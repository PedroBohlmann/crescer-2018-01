import React from 'react'

import { Input } from "reactstrap";

export default class TrechoLinhaTabelaSimplificada extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.trecho.origem.cidade} - {this.props.trecho.origem.aeroporto}</td>
                <td>{this.props.trecho.destino.cidade} - {this.props.trecho.destino.aeroporto}</td>
                <td>{this.props.trecho.distanciaTotal}</td>
                <td><Input id={this.props.trecho.id} name="trecho" type="radio" onChange={this.props.onChange} /></td>
            </tr>
        )

    }
}