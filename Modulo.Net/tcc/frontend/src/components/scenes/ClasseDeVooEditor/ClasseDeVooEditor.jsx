import React from 'react'

import CustomNavbar from '../../CustomNavbar/CustomNavbar'

import { Input, Label, Button,Table } from "reactstrap";

import ClasseDeVooService from '../../../service/ClasseDeVooService'

import ClasseDeVooTabelaLinha from '../../ClasseDeVooTabelaLinha/ClasseDeVooTabelaLinha'

import './ClasseDeVooEditor.css'

export default class ClasseDeVooEditor extends React.Component{

    constructor(){
        super()
        this.state={
            descricao:"",
            valorFixo:0.0,
            valorMilha:0.0,
            classes:[],
            editarClasse:false,
            id:0
        }
        this.handleChange=this.handleChange.bind(this)
        this.onSubmit=this.onSubmit.bind(this)
        this.onDelete=this.onDelete.bind(this)
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

    limpaState(){
        this.setState({
            descricao:"",
            valorFixo:0.0,
            valorMilha:0.0,
            editarClasse:false,
            id:0
        })
    }

    onSubmit(e){
        var valorMilhaFloat = parseFloat(this.state.valorMilha)
        var valorFixoFloat = parseFloat(this.state.valorFixo)

        var classeDeVoo = {
            descricao:this.state.descricao,
            valorMilha:valorMilhaFloat,
            valorFixo:valorFixoFloat
        }
        if(this.state.editarClasse){
            ClasseDeVooService.atualizar(this.state.id,classeDeVoo,localStorage.token)
                .then((result)=>{
                    console.log('editou')
                    this.carregaClassesApi()
                    this.limpaState()
                })
                .catch((error)=>{
                    console.log(error)
                })
        }else{
            ClasseDeVooService.cadastrar(classeDeVoo,localStorage.token)
                .then((result)=>{
                    console.log('cadastrou')
                    this.carregaClassesApi()
                    this.limpaState()
                })
                .catch((error)=>{
                    console.log(error)
                })
        }
    }

    carregaClassesApi(){
        ClasseDeVooService.listar(localStorage.token)
            .then((result)=>{
                this.setState({
                    classes:result.data
                })
            })
            .catch((error)=>{
                console.log(error)
            })
    }

    componentDidMount(){
        this.carregaClassesApi()
    }

    renderClassesDeVoo(){
        return this.state.classes.map((classe,index)=>{
            return <ClasseDeVooTabelaLinha classeDeVoo={classe} key={index} onDelete={this.onDelete} onEdit={this.onEdit}/>
        })
    }

    onDelete(e){
        ClasseDeVooService.deletar(localStorage.token,e.target.name)
            .then((result)=>{
                console.log('deletou')
                this.carregaClassesApi()
            })
            .catch((error)=>{
                console.log(error)
            })
    }

    onEdit(e){
        ClasseDeVooService.obter(localStorage.token,e.target.name)
        .then((result)=>{
            this.setState({
                descricao:result.data.descricao,
                valorFixo:result.data.valorFixo,
                valorMilha:result.data.valorMilha,
                id:result.data.id,
                editarClasse:true
            })
        })
        .catch((error)=>{
            console.log(error)
        }) 
    }


    render(){
        return(
            <div>
                <CustomNavbar/>
                <div className="classe-de-voo-form">
                    <div className="display-4">Classe de voo</div>
                    <div className="classe-de-voo-form-row">
                        <Label for="descricao">Descrição</Label>
                        <Input
                            type="text"
                            id="descricao"
                            placeholder="Descricao aqui!!"
                            onChange={this.handleChange}
                            name="descricao"
                            value={this.state.descricao||''}
                        />
                    </div>
                    <div className="classe-de-voo-form-row">
                        <Label for="valorFixo">Valor fixo</Label>
                        <Input
                            type="number"
                            id="valorFixo"
                            placeholder="Valor fixo aqui!!"
                            onChange={this.handleChange}
                            name="valorFixo"
                            value={this.state.valorFixo||''}
                        />
                        <Label for="valorMilha">Valor Milha</Label>
                        <Input
                            type="number"
                            id="valorMilha"
                            placeholder="Valor milha aqui!!"
                            onChange={this.handleChange}
                            name="valorMilha"
                            value={this.state.valorMilha||''}
                        />
                        <Button color="success" onClick={this.onSubmit} name="salvar">
                            Salvar
                        </Button>
                    </div>
                    <Table>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Descricao</th>
                                <th>Valor Fixo</th>
                                <th>Valor Milha</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.renderClassesDeVoo()}
                        </tbody>
                    </Table>

                </div>
            </div>
        )
    }
}