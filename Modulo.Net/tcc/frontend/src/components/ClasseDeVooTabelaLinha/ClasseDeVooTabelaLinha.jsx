import React from 'react'
import { Button } from "reactstrap";

export default class ClasseDeVooTabelaLinha extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.classeDeVoo.id}</td>
                <td>{this.props.classeDeVoo.descricao}</td>
                <td>{this.props.classeDeVoo.valorFixo}</td>
                <td>{this.props.classeDeVoo.valorMilha}</td>
                <td><Button name={this.props.classeDeVoo.id} onClick={this.props.onEdit} color="warning">Editar</Button></td>
                <td><Button name={this.props.classeDeVoo.id} onClick={this.props.onDelete} color="danger">Deletar</Button></td>
            </tr>
        )
    }
}