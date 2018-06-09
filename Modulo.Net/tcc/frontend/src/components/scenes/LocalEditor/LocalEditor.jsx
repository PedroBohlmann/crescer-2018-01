import React from 'react'

import CustomNavbar from '../../CustomNavbar/CustomNavbar'

import './LocalEditor.css'

import { Input, Label, Button } from "reactstrap";


export default class LocalEditor extends React.Component {

    constructor() {
        super()
        this.state = {
            nomeCidade: "",
            aeroporto: "",
            latitude: 0.0,
            longitude: 0.0
        }
        this.handleChange = this.handleChange.bind(this)
        this.onSubmit=this.onSubmit.bind(this)
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        this.setState({
            [name]: value
        });
    }

    onSubmit(e){
        var latitudeFloat = parseFloat(this.state.latitude)
        var longitudeFloat = parseFloat(this.state.longitude)
        this.setState({
            longitude:longitudeFloat,
            latitude:latitudeFloat
        })
        console.log(this.state)

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
                            id="nomeCidade"
                            placeholder="Nome da cidade aqui!!"
                            onChange={this.handleChange}
                            name="nomeCidade"
                        />
                        <Label for="aeroporto">Aeroporto</Label>
                        <Input
                            type="text"
                            id="aeroporto"
                            placeholder="nome do aeroporto aqui"
                            onChange={this.handleChange}
                            name="ultimoNome"
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
                </div>
            </div>
        )
    }
}