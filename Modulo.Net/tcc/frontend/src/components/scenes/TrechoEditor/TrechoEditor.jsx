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
            trechos:[],
            id: 0
        }
        this.handleChange = this.handleChange.bind(this)
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        this.setState({
            [name]: value
        });
    }

    carregaLocaisApi() {
        LocalService.listar(localStorage.token)
            .then((result) => {
                this.setState({
                    locais: result.data
                })
            })
            .catch((error) => {
                console.log(error)
            })
    }

    carregaTrechosApi(){
        TrechoService.listar(localStorage.token)
            .then((result)=>{
                this.setState({
                    trechos:result.data
                })
            })
            .catch((error)=>{
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

    renderTrechos(){
        return this.state.trechos.map((trecho, index) => {
            return <TrechoLinhaTabela key={index} trecho={trecho} />//onDelete={this.onDelete} onEdit={this.onEdit}/>
        })
    }

    render() {
        return (
            <div>
                <CustomNavbar />
                <div className="trecho-editor-container">
                    <div className="trecho-editor-container-row">
                        <Label for="origem">Origem</Label>
                        <Input className="selects" type="select" id="origem" name="origem">
                            {this.renderLocaisSelect()}
                        </Input>
                    </div>
                    <div className="trecho-editor-container-row">
                        <Label for="destino">Destino</Label>
                        <Input className="selects" type="select" id="destino" name="destino">
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
            </div>
        )
    }
}