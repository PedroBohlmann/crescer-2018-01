import React from 'react'

import Button from '../generic/Button/Button'
import Input from '../generic/Input/Input'

import LoginService from '../../Services/LoginService'

export default class LoginForm extends React.Component{

    constructor(){
        super()
        this.state=this.getInitialState()
        this.handdleChange=this.handdleChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
    }

    getInitialState(){
        return{
            email:'',
            name:''
        }
    }

    handdleChange(event) {
        const target = event.target
        const value = target.value
        const name = target.name
        this.setState({
            [name]: value
        })
    }

    onSubmit(e){
        LoginService.login(this.state.email,this.state.password)
        .then((result)=>{
            localStorage.accessToken=result.data.accessToken
            this.props.redirectTo('MOVIESTAB')
        }).catch((error)=>{
            console.log(error)
        })
    }

    render(){
        return(
            <div className="d-flex justify-content-center">
                <form>
                    <h1 className="display-4">Login</h1>
                    <Input type="email"  onChange={this.handdleChange} placeholder="Email aqui!" name="email" id="email" label="Email"/>
                    <Input type="password" onChange={this.handdleChange} placeholder="Senha aqui!" name="password" id="password" label="Senha"/>
                    <Button type="button" onClick={this.onSubmit} typeButton="btn-primary" text="Logar"/>
                    <Button type="button" onClick={this.props.onClick} id="REGISTERSCREEN" typeButton="btn-primary" text="Registrar-se aqui"/>
                </form>
            </div>
        )
    }
} 