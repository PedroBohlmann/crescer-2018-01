import React from "react"

import CustomNavbar from '../../CustomNavbar/CustomNavbar'

import { Input, Label, Button, Table } from "reactstrap";

import OpcionalService from '../../../service/OpcionalService'

import TrechoService from '../../../service/TrechoService'

import ClasseDeVooService from '../../../service/ClasseDeVooService'

import TrechoLinhaTabelaSimplificada from './TrechoLinhaTabelaSimplificada/TrechoLinhaTabelaSimplificada'

import OpcionaisLinhaTabelaSimplificada from './OpcionaisLinhaTabelaSimplificada/OpcionaisLinhaTabelaSimplificada'

import ReservaLinhaTabela from '../../ReservaLinhaTabela/ReservaLinhaTabela'

import ReservaService from '../../../service/ReservaService'

import './Home.css'
import UsuarioService from "../../../service/UsuarioService";

export default class Home extends React.Component {

    constructor() {
        super()
        this.state = {
            origemCidade: "",
            destinoCidade: "",
            trechos: [],
            opcionais: [],
            trechosComFiltro: [],
            opcionaisList: [],
            classes: [],
            classe: 0,
            trecho: 0,
            valor: 0.0,
            reservas: []
        }
        this.handleChange = this.handleChange.bind(this)
        this.handleChangeForTrechos = this.handleChangeForTrechos.bind(this)
        this.handleChangeOpcionais = this.handleChangeOpcionais.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
        this.onDelete = this.onDelete.bind(this)
        this.onClickPesquisar = this.onClickPesquisar.bind(this)
        this.filtroTrecho = this.filtroTrecho.bind(this)
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        this.setState({
            [name]: value
        });
        this.carregarValorTotal()
    }

    handleChangeForTrechos(event) {
        const target = event.target;
        const value = target.id;
        const name = target.name;
        this.setState({
            [name]: value
        });
        this.carregarValorTotal()
    }

    handleChangeOpcionais(e) {
        var opcionaisLista = this.state.opcionaisList
        const value = e.target.id;
        const posicao = opcionaisLista.indexOf(value)
        if (posicao < 0) {
            opcionaisLista.push(value)
            this.setState({
                opcionaisList: opcionaisLista
            })
        }
        else {
            opcionaisLista.splice(posicao, 1)
            this.setState({
                opcionaisList: opcionaisLista
            })
        }
        this.carregarValorTotal()
    }

    carregaTrechosApi() {
        TrechoService.listar(localStorage.token)
            .then((result) => {
                this.setState({
                    trechos: result.data
                })
                this.filtrar()
            })
            .catch((error) => {
                console.log(error)
            })
    }

    filtroTrecho(trecho){
        if(this.state.origemCidade!==""){
            if(this.state.destinoCidade!==""){
                return trecho.origem.cidade==this.state.origemCidade && trecho.destino.cidade==this.state.destinoCidade
            }
            else{
                return trecho.origem.cidade==this.state.origemCidade
            }
        }
        else if (this.state.destinoCidade!==""){
            return trecho.destino.cidade==this.state.destinoCidade
        }
        return true
    }

    filtrar(){
        var filtrados = this.state.trechos.filter(this.filtroTrecho)
        this.setState({
            trechosComFiltro:filtrados
        })
    }

    onClickPesquisar(){
        this.filtrar()
    }

    carregarValorTotal() {
        var data = {
            idClasseDeVoo: this.state.classe,
            idUsuario: UsuarioService.getTokenInfo()["http://schemas.xmlsoap.org/ws/2005/05/identity/claims/sid"],
            idTrecho: this.state.trecho,
            idOpcionais: this.state.opcionaisList
        }
        ReservaService.valor(data, localStorage.token)
            .then((result) => {
                this.setState({
                    valor: result.data.valorTotal
                })
            })
            .catch((error) => {
                console.log(error)
            })
    }

    carregaOpcionaisApi() {
        OpcionalService.listar(localStorage.token)
            .then((result) => {
                this.setState({
                    opcionais: result.data
                })
            })
            .catch((error) => {
                console.log(error)
            })
    }

    carregaReservasApi() {
        ReservaService.listar(UsuarioService.getTokenInfo()["http://schemas.xmlsoap.org/ws/2005/05/identity/claims/sid"], localStorage.token)
            .then((result) => {
                this.setState({
                    reservas: result.data
                })
            })
            .catch((error) => {
                console.log(error)
            })
    }

    carregaClassesApi() {
        ClasseDeVooService.listar(localStorage.token)
            .then((result) => {
                this.setState({
                    classes: result.data
                })

                var classes = this.state.classes

                this.setState({
                    classe: classes[0].id
                })
            })
            .catch((error) => {
                console.log(error)
            })
    }

    renderClassesDeVoo() {
        return this.state.classes.map((classe, index) => {
            return <option key={index} value={classe.id}>{classe.descricao}</option>
        })
    }

    componentDidMount() {
        this.carregaTrechosApi()
        this.carregaOpcionaisApi()
        this.carregaClassesApi()
        this.carregaReservasApi()
        this.filtrar()
    }

    renderTrechos() {
        return this.state.trechosComFiltro.map((trecho, index) => {
            return <TrechoLinhaTabelaSimplificada key={index} trecho={trecho} onChange={this.handleChangeForTrechos} />
        })
    }

    renderOpcionais() {
        return this.state.opcionais.map((opcional, index) => {
            return <OpcionaisLinhaTabelaSimplificada key={index} opcional={opcional} onChange={this.handleChangeOpcionais} />
        })
    }

    renderReservas() {
        return this.state.reservas.map((reserva, index) => {
            return <ReservaLinhaTabela key={index} reserva={reserva} onDelete={this.onDelete} />
        })
    }

    onSubmit(e) {
        var data = {
            idClasseDeVoo: this.state.classe,
            idUsuario: UsuarioService.getTokenInfo()["http://schemas.xmlsoap.org/ws/2005/05/identity/claims/sid"],
            idTrecho: this.state.trecho,
            idOpcionais: this.state.opcionaisList
        }
        ReservaService.cadastrar(data, localStorage.token)
            .then((result) => {
                console.log("cadastrou moh vei")
                this.carregaReservasApi()
            })
            .catch((error) => {
                console.log(error)
            })
    }

    onDelete(e) {
        ReservaService.deletar(e.target.name, localStorage.token)
            .then((result) => {
                this.carregaReservasApi()
            })
            .catch((error) => {
                console.log(error)
            })
    }


    render() {
        return (
            <div>
                <CustomNavbar />
                <div className="home-container">
                    <div className="home-container-row">
                        <Label for="origemCidade">Cidade de origem</Label>
                        <Input
                            type="text"
                            id="origemCidade"
                            placeholder="Nome da cidade de origem aqui!!"
                            onChange={this.handleChange}
                            name="origemCidade"
                            value={this.state.origemCidade || ''}
                        />
                        <Label for="origemDestino">Cidade de destino</Label>
                        <Input
                            type="text"
                            id="destinoCidade"
                            placeholder="Nome da cidade de destino aqui!!"
                            onChange={this.handleChange}
                            name="destinoCidade"
                            value={this.state.destinoCidade || ''}
                        />
                        <Button color="success" name="pesquisar" onClick={this.onClickPesquisar}>
                            Pesquisar Trecho
                        </Button>
                    </div>
                    <div className="home-container-row">
                        <Table>
                            <thead>
                                <tr>
                                    <th>Origem</th>
                                    <th>Destino</th>
                                    <th>Distancia</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.renderTrechos()}
                            </tbody>
                        </Table>
                    </div>
                    <div className="display-4">Opcionais</div>
                    <div className="home-container-row">
                        <Table>
                            <thead>
                                <tr>
                                    <th>Nome</th>
                                    <th>Descricao</th>
                                    <th>Valor Porcentagem</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.renderOpcionais()}
                            </tbody>
                        </Table>
                    </div>
                    <div className="home-container-row">
                        <Label for="classe">Classes</Label>
                        <Input type="select" id="classe" name="classe" onChange={this.handleChange} value={this.state.origem}>
                            {this.renderClassesDeVoo()}
                        </Input>
                        <Label for="valor">Valor total</Label>
                        <Input
                            type="number"
                            disabled
                            id="valor"
                            onChange={this.handleChange}
                            name="valor"
                            value={this.state.valor || 0}
                        />
                    </div>
                    <div className="home-container-row">
                        <Button color="success" name="salvar" onClick={this.onSubmit}>
                            Salvar
                        </Button>
                    </div>
                    <div className="home-container-row">
                        <Table>
                            <thead>
                                <tr>
                                    <th>Trecho</th>
                                    <th>Valor</th>
                                    <th>Ação</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.renderReservas()}
                            </tbody>
                        </Table>
                    </div>
                </div>
            </div>
        )
    }
}