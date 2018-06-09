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
            latitude: 0.0,
            longitude: 0.0,
            locais:[]
        }
        this.handleChange = this.handleChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        this.setState({
            [name]: value
        });
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
        LocalService.cadastrar(local, localStorage.token)
            .then((result) => {
                console.log('cadastrou')
            })
            .catch((error) => {
                console.log(error)
            })

    }

    renderLocais(){
        return this.state.locais.map((local,index)=>{
            return <LocalLinhaTabela key={index} usuario={local}/>
        })
    }

    carregaLocaisApi(){
        LocalService.listar(localStorage.token)
            .then((result)=>{
                this.setState({
                    locais:result.data
                })
            })
            .catch((error)=>{
                console.log(error)
            })
    }

    componentDidMount(){
        this.carregaLocaisApi()
    }

    render() {
        return (
            <div>
                <CustomNavbar />
                <div className="local-editor-container">
                    <div className="local-editor-form-line">
                        <Label for="nomeCidade">Nome da cidade</Label>
                        <Input
                            type="text"
                            id="cidade"
                            placeholder="Nome da cidade aqui!!"
                            onChange={this.handleChange}
                            name="cidade"
                        />
                        <Label for="aeroporto">Aeroporto</Label>
                        <Input
                            type="text"
                            id="aeroporto"
                            placeholder="nome do aeroporto aqui"
                            onChange={this.handleChange}
                            name="aeroporto"
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
                        />
                        <Label for="longitude">Longitude</Label>
                        <Input
                            type="number"
                            id="longitude"
                            placeholder="longitude aqui"
                            onChange={this.handleChange}
                            name="longitude"
                        />
                    </div>
                    <Button color="success" onClick={this.onSubmit}>
                        Salvar
                    </Button>
                    <br />
                    <Table>
                        <thead>
                            <tr>
                                <th>Cidade</th>
                                <th>Aeroporto</th>
                                <th>Latitude</th>
                                <th>Longitude</th>
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