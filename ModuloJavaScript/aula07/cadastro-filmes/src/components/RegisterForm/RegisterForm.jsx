import React from 'react'

import Button from '../generic/Button/Button'
import Input from '../generic/Input/Input'
import RegisterService from '../../Services/RegisterService'

export default class RegisterForm extends React.Component{
    
    constructor(){
        super()
        this.state = this.getInitialState()
        this.handdleChange=this.handdleChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
    }

    handdleChange(event) {
        const target = event.target
        const value = target.value
        const name = target.name
        this.setState({
            [name]: value
        })
    }

    getInitialState(){
        return {
            name:'',
            email:'',
            password:''
        }
    }

    onSubmit(e){
        RegisterService.register(this.state.email,this.state.name,this.state.password)
        .then((result)=>{
            console.log(result)
            this.props.redirectTo('LOGIN')
        }).catch((error)=>{
            console.log(error)
        })
    }

    render(){
        return (
            <div className="d-flex justify-content-center">
                <form>
                    <h1 className="display-4">Cadastro</h1>
                    <Input type="email" onChange={this.handdleChange} placeholder="Email aqui!" name="email" id="email" label="Email"/>
                    <Input type="text" onChange={this.handdleChange} placeholder="Nome aqui!" name="name" id="name" label="Nome"/>
                    <Input type="password" onChange={this.handdleChange} placeholder="Senha aqui!" name="password" id="password" label="Senha"/>
                    <Button type="button" onClick={this.onSubmit} typeButton="btn-primary" text="Registrar-se"/>
                    <Button type="button" onClick={this.props.onClick} id="LOGIN" typeButton="btn-primary" text="Voltar para login"/>
                </form>
            </div>
        )
    }
}