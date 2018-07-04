import React from 'react';

import { Input, Label, Button } from "reactstrap";

import LoginService from '../../../service/LoginService';

import { Redirect } from "react-router-dom";

import "./Register.css"
import UsuarioService from '../../../service/LoginService';

export default class Register extends React.Component{

    constructor(){
        super()
        this.state = {
            email:"",
            password:"",
            username:"",
            nickname:"",
            dateOfBirth:null,
            imageUrl:"",
            toLogin:false
        }
        this.handleChange = this.handleChange.bind(this)
        this.toLogin = this.toLogin.bind(this)
        this.onRegister = this.onRegister.bind(this)
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        this.setState({
          [name]: value
        });
    }

    onRegister(event){
        let data={
            nome:this.state.username,
            email:this.state.email,
            apelido:this.state.nickname,
            dataDeNascimento:this.state.dateOfBirth,
            senha:this.state.password,
            imagemUrl:this.state.imageUrl
        }
        UsuarioService.register(data)
            .then((result)=>{
                console.log("cadastrado")
            })
            .catch((error)=>{
                console.log(error)
            })
    }

    toLogin(event){
        this.setState({
            toLogin:true
        })
    }

    render(){
        return(
            <div className="register-container">
                <img src="https://cdn.discordapp.com/attachments/361913998851178507/463173846007152641/logo_do_petter_white.png" width="25%" className="floating-logo-register"/>
                {this.state.toLogin ? (<Redirect to="/"/>): (undefined)}
                <div className="register-form-container">
                       <div className="register-form-container-group">
                            <h2>Register</h2>
                            <Label for="email">Email</Label>
                            <Input
                                type="email"
                                id="email"
                                placeholder="email@here"
                                onChange={this.handleChange}
                                name="email"
                            />

                            <Label for="username">Name</Label>
                            <Input
                                type="text"
                                id="username"
                                placeholder="email@here"
                                onChange={this.handleChange}
                                name="username"
                            />

                            <Label for="password">Password</Label>
                            <Input
                                type="password"
                                id="password"
                                placeholder="password here!"
                                onChange={this.handleChange}
                                name="password"
                            />

                            <Label for="nickname">Nickname</Label>
                            <Input
                                type="text"
                                id="nickname"
                                placeholder="nickname here!"
                                onChange={this.handleChange}
                                name="nickname"
                            />

                            <Label for="dateOfBirth">Date of birth</Label>
                            <Input
                                type="date"
                                id="dateOfBirth"
                                onChange={this.handleChange}
                                name="dateOfBirth"
                            />

                            <Label for="imageUrl">Image Url</Label>
                            <Input
                                type="text"
                                id="imageUrl"
                                onChange={this.handleChange}
                                name="imageUrl"
                            />

                            <div className="register-form-container-button-group">
                                <Button color="success" onClick={this.onRegister}>
                                    Register
                                </Button>
                                <Button color="primary" onClick={this.toLogin}>
                                    Back to Login
                                </Button>
                            </div>
                        </div>
                    </div>
            </div>
        )
    }
}