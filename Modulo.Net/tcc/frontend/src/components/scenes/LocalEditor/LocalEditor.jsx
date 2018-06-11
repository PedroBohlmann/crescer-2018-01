import React from 'react'

import CustomNavbar from '../../CustomNavbar/CustomNavbar'

import './LocalEditor.css'

import { Input, Label, Button, Table } from "reactstrap";

import LocalService from '../../../service/LocalService'

import LocalLinhaTabela from '../../LocalLinhaTabela/LocalLinhaTabela'

export default class LocalEditor extends React.Component {

    constructor() {
        super()
        this.state = {
            cidade: "",
            aeroporto: "",
            latitude: 0,
            longitude: 0,
            id: 0,
            locais: [],
            editarLocal: false
        }
        this.handleChange = this.handleChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
        this.onDelete = this.onDelete.bind(this)
        this.limpaState = this.limpaState.bind(this)
        this.onEdit=this.onEdit.bind(this)
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        this.setState({
            [name]: value
        });
    }

    limpaState() {
        this.setState({
            cidade: "",
            aeroporto: "",
            latitude: 0.0,
            longitude: 0.0,
            id: 0,
            editarLocal: false
        })
    }

    onSubmit(e) {
        var latitudeFloat = parseFloat(this.state.latitude)
        var longitudeFloat = parseFloat(this.state.longitude)
        var local = {
            cidade: this.state.cidade,
            aeroporto: this.state.aeroporto,
            longitude: longitudeFloat,
            latitude: latitudeFloat
        }
        if (this.state.editarLocal) {
            LocalService.editar(this.state.id,local, localStorage.token)
                .then((result) => {
                    console.log('editou')
                    this.carregaLocaisApi()
                    this.limpaState()
                })
                .catch((error) => {
                    console.log(error)
                })
        } else {
            LocalService.cadastrar(local, localStorage.token)
                .then((result) => {
                    console.log('cadastrou')
                    this.carregaLocaisApi()
                    this.limpaState()
                })
                .catch((error) => {
                    console.log(error)
                })
        }
    }

    onDelete(e) {
        LocalService.deletar(localStorage.token, e.target.name)
            .then((result) => {
                console.log('deletou')
                this.carregaLocaisApi()
            })
            .catch((error) => {
                console.log(error)
            })
    }

    onEdit(e) {
        LocalService.obter(localStorage.token, e.target.name)
            .then((result) => {
                console.log('obteve')
                this.setState({
                    cidade: result.data.cidade,
                    aeroporto: result.data.aeroporto,
                    longitude: result.data.longitude,
                    latitude: result.data.latitude,
                    id: result.data.id,
                    editarLocal:true
                })
            })
            .catch((error) => {
                console.log(error)
            })
    }

    renderLocais() {
        return this.state.locais.map((local, index) => {
            return <LocalLinhaTabela key={index} local={local} onDelete={this.onDelete} onEdit={this.onEdit}/>
        })
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

    componentDidMount() {
        this.carregaLocaisApi()
    }

    render() {
        return (
            <div>
                <CustomNavbar />
                <div className="local-editor-container">
                <div className="display-4">Local</div>
                    <div className="local-editor-form-line">
                        <Label for="nomeCidade">Nome da cidade</Label>
                        <Input
                            type="text"
                            id="cidade"
                            placeholder="Nome da cidade aqui!!"
                            onChange={this.handleChange}
                            name="cidade"
                            value={this.state.cidade||''}
                        />
                        <Label for="aeroporto">Aeroporto</Label>
                        <Input
                            type="text"
                            id="aeroporto"
                            placeholder="nome do aeroporto aqui"
                            onChange={this.handleChange}
                            name="aeroporto"
                            value={this.state.aeroporto||''}
                        />
                    </div>
                    <div className="local-editor-form-line">
                        <Label for="latitude">Latitude</Label>
                        <Input
                            type="number"
                            id="latitude"
                            placeholder="latitude aqui"
                            onChange={this.handleChange}
                            name="latitude"
                            value={this.state.latitude||0}
                        />
                        <Label for="longitude">Longitude</Label>
                        <Input
                            type="number"
                            id="longitude"
                            placeholder="longitude aqui"
                            onChange={this.handleChange}
                            name="longitude"
                            value={this.state.longitude||0}
                        />
                    </div>
                    <div className="local-editor-form-line">
                        <Button color="success" onClick={this.onSubmit} name="salvar">
                            Salvar
                        </Button>
                        <Button color="danger" onClick={this.limpaState} name="novo-local">
                            Reset formulario
                        </Button>
                    </div>
                    <br />
                    <Table>
                        <thead>
                            <tr>
                                <th>Cidade</th>
                                <th>Aeroporto</th>
                                <th>Latitude</th>
                                <th>Longitude</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.renderLocais()}
                        </tbody>
                    </Table>
                </div>
            </div>
        )
    }
}