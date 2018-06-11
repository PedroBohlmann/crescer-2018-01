import React from 'react'

import CustomNavbar from '../../CustomNavbar/CustomNavbar'

import { Button, Label, Input, Table } from 'reactstrap';

import LocalService from '../../../service/LocalService'

import TrechoService from '../../../service/TrechoService'

import TrechoLinhaTabela from '../../TrechoLinhaTabela/TrechoLinhaTabela'

import './TrechoEditor.css'

export default class TrechoEditor extends React.Component {

    constructor() {
        super()
        this.state = {
            origem: 0,
            destino: 0,
            distancia: 0,
            locais: [],
            trechos: [],
            id: 0,
            editarTrecho: false
        }
        this.handleChange = this.handleChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
        this.onDelete = this.onDelete.bind(this)
        this.onEdit = this.onEdit.bind(this)
        this.limpaState = this.limpaState.bind(this)
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        this.setState({
            [name]: value
        });
        this.atualizaDistancia()
    }

    atualizaDistancia() {
        var trecho = {
            origem: this.state.origem,
            destino: this.state.destino
        }
        TrechoService.obterDistancia(trecho, localStorage.token)
            .then((result) => {
                this.setState({
                    distancia:result.data.distanciaTotal
                })
            })
    }

    carregaLocaisApi() {
        LocalService.listar(localStorage.token)
            .then((result) => {
                this.setState({
                    locais: result.data
                })
                var origemId = this.state.locais[0].id
                var destinoId = this.state.locais[0].id

                this.setState({
                    origem: origemId,
                    destino: destinoId
                })
            })
            .catch((error) => {
                console.log(error)
            })
    }

    carregaTrechosApi() {
        TrechoService.listar(localStorage.token)
            .then((result) => {
                this.setState({
                    trechos: result.data
                })
            })
            .catch((error) => {
                console.log(error)
            })
    }

    componentDidMount() {
        this.carregaLocaisApi()
        this.carregaTrechosApi()
    }

    renderLocaisSelect() {
        return this.state.locais.map((local, index) => {
            return <option key={index} value={local.id}>{local.cidade} - {local.aeroporto}</option>
        })
    }

    onSubmit(e) {
        var trecho = {
            origem: this.state.origem,
            destino: this.state.destino
        }
        if (this.state.editarTrecho) {
            TrechoService.atualizar(this.state.id, trecho, localStorage.token)
                .then((result) => {
                    this.carregaTrechosApi()
                    this.limpaState()
                })
                .catch((error) => {
                    console.log(error)
                })
        } else {
            TrechoService.cadastrar(trecho, localStorage.token)
                .then((result) => {
                    this.carregaTrechosApi()
                    this.limpaState()
                })
                .catch((error) => {
                    console.log(error)
                })
        }
    }

    limpaState() {
        var origemId = this.state.locais[0].id
        var destinoId = this.state.locais[0].id

        this.setState({
            origem: origemId,
            destino: destinoId,
            distancia: 0,
            id: 0,
            editarTrecho: false
        })
    }

    onEdit(e) {
        TrechoService.obter(e.target.name, localStorage.token)
            .then((result) => {
                var idOrigem = result.data.origem.id
                var idDestino = result.data.destino.id
                var idTrecho = result.data.id
                var distanciaTotal = result.data.distanciaTotal

                this.setState({
                    origem: idOrigem,
                    destino: idDestino,
                    id: idTrecho,
                    editarTrecho: true,
                    distancia: distanciaTotal
                })
            })
    }

    renderTrechos() {
        return this.state.trechos.map((trecho, index) => {
            return <TrechoLinhaTabela key={index} trecho={trecho} onDelete={this.onDelete} onEdit={this.onEdit} />
        })
    }

    onDelete(e) {
        TrechoService.deletar(e.target.name, localStorage.token)
            .then((result) => {
                this.carregaTrechosApi()
            })
            .catch((error) => {
                console.log(error)
            })
    }

    render() {
        return (
            <div>
                <CustomNavbar />
                <div className="trecho-editor-container">
                    <div className="trecho-editor-container-row">
                        <Label for="origem">Origem</Label>
                        <Input className="selects" type="select" id="origem" name="origem" onChange={this.handleChange} value={this.state.origem}>
                            {this.renderLocaisSelect()}
                        </Input>
                    </div>
                    <div className="trecho-editor-container-row">
                        <Label for="destino">Destino</Label>
                        <Input className="selects" type="select" id="destino" name="destino" onChange={this.handleChange} value={this.state.destino}>
                            {this.renderLocaisSelect()}
                        </Input>
                    </div>
                    <div>
                        <Input
                            type="number"
                            disabled
                            id="distancia"
                            onChange={this.handleChange}
                            name="cidade"
                            value={this.state.distancia || 0}
                        />
                    </div>
                    <div>
                        <Button color="success" onClick={this.onSubmit} name="salvar">
                            Salvar
                        </Button>
                        <Button color="danger" onClick={this.limpaState} name="novo-local">
                            Reset formulario
                        </Button>
                    </div>
                    <Table>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Origem</th>
                                <th>Destino</th>
                                <th>Distancia em milhas</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.renderTrechos()}
                        </tbody>
                    </Table>
                </div>
            </div >
        )
    }
}