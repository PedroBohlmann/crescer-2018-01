import React from 'react'

import CustomNavbar from '../../CustomNavbar/CustomNavbar'

import { Input, Label, Button, Table } from "reactstrap";

import OpcionalService from '../../../service/OpcionalService'

import './OpcionalEditor.css'

import OpcionalLinhaTabela from '../../OpcionalLinhaTabela/OpcionalLinhaTabela'

export default class OpcionalEditor extends React.Component {

    constructor() {
        super()
        this.state = {
            nome: "",
            descricao: "",
            valor: "",
            opcionais:[],
            editarOpcional:false,
            id:0
        }
        this.onSubmit=this.onSubmit.bind(this)
        this.handleChange=this.handleChange.bind(this)
        this.onDelete=this.onDelete.bind(this)
        this.onEdit=this.onEdit.bind(this)
        this.limpaState=this.limpaState.bind(this)
    }

    onSubmit(e){
        var opcional = {
            nome:this.state.nome,
            descricao:this.state.descricao,
            valorPorcentagem:this.state.valor
        }
        if(this.state.editarOpcional){
            OpcionalService.atualizar(this.state.id,opcional,localStorage.token)
                .then((result)=>{
                    this.carregaOpcionaisApi()
                    this.limpaState()
                })
                .catch((error)=>{
                    console.log(error)
                })
        }
        else{
            OpcionalService.cadastrar(opcional,localStorage.token)
                .then((result)=>{
                    console.log("cadastrou")
                    this.carregaOpcionaisApi()
                    this.limpaState()
                })
                .catch((error)=>{
                    console.log(error)
                })
        }
    }

    limpaState(){
        this.setState({
            nome: "",
            descricao: "",
            valor: "",
            editarOpcional:false,
            id:0
        })
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        this.setState({
            [name]: value
        });
    }

    componentDidMount(){
        this.carregaOpcionaisApi()
    }

    carregaOpcionaisApi(){
        OpcionalService.listar(localStorage.token)
            .then((result)=>{
                this.setState({
                    opcionais:result.data
                })
            })
            .catch((error)=>{
                console.log(error)
            })
    }

    onDelete(e){
        OpcionalService.deletar(localStorage.token,e.target.name)
            .then((result)=>{
                this.carregaOpcionaisApi()
            })
            .catch((error)=>{
                console.log(error)
            })
    }

    onEdit(e){
        OpcionalService.obter(localStorage.token,e.target.name)
            .then((result)=>{
                this.setState({
                    nome: result.data.nome,
                    descricao: result.data.descricao,
                    valor: result.data.valorPorcentagem,
                    editarOpcional:true,
                    id:result.data.id
                })
            })
    }

    renderOpcionais(){
        return this.state.opcionais.map((opcional, index) => {
            return <OpcionalLinhaTabela key={index} opcional={opcional} onDelete={this.onDelete} onEdit={this.onEdit}/>
        })
    }

    render() {
        return <div>
            <CustomNavbar />
            <div className="opcional-editor-container">
                <div className="display-4">Opcional</div>
                <div className="opcional-editor-form-line">
                    <Label for="nome">Nome</Label>
                    <Input
                        type="text"
                        id="nome"
                        placeholder="Nome do opcional aqui!!"
                        onChange={this.handleChange}
                        name="nome"
                        value={this.state.nome || ''}
                    />
                </div>
                <div className="opcional-editor-form-line">
                    <Label for="descricao">Descricao</Label>
                    <Input
                        type="textarea"
                        id="descricao"
                        placeholder="descricao aqui"
                        onChange={this.handleChange}
                        name="descricao"
                        value={this.state.descricao || ''}
                    />
                </div>
                <div className="opcional-editor-form-line">
                    <Label for="valor">Valor</Label>
                    <Input
                        type="number"
                        id="valor"
                        placeholder="valor aqui"
                        onChange={this.handleChange}
                        name="valor"
                        value={this.state.valor || 0}
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
                            <th>Id</th>
                            <th>Nome</th>
                            <th>Descricao</th>
                            <th>Valor</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.renderOpcionais()}
                    </tbody>
                </Table>
            </div>
        </div>
    }
}