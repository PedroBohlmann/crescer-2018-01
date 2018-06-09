import React from 'react'

export default class LocalLinhaTabela extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.usuario.cidade}</td>
                <td>{this.props.usuario.aeroporto}</td>
                <td>{this.props.usuario.latitude}</td>
                <td>{this.props.usuario.longitude}</td>
            </tr>
        )
    }
}