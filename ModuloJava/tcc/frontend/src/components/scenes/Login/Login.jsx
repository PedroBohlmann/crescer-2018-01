import React from 'react'

import { Input, Label, Button } from "reactstrap";

import LoginService from '../../../service/LoginService';

import { Redirect } from "react-router-dom";

import "./Login.css"

export default class Login extends React.Component {

    constructor(){
        super()
        this.state = {
            email :"",
            password:"",
            directToRegister:false,
            logged:false
        }
        this.handleChange = this.handleChange.bind(this)
        this.onLogin = this.onLogin.bind(this)
        this.toRegister = this.toRegister.bind(this)
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        this.setState({
          [name]: value
        });
    }

    onLogin(event){
        LoginService.login(this.state.email,this.state.password)
            .then((result)=>{
                localStorage.token = result.data.accessToken
                this.setState({
                    logged:true
                })
            })
            .catch((error)=>{
                console.log(error)
            })
    }

    toRegister(event){
        this.setState({
            directToRegister:true
        })
    }
    
    render() {
        return (
            <div className="login-container">
                <div className="login-form-container">
                    {this.state.directToRegister ? (<Redirect to="/register"/>): (undefined)}
                    {this.state.logged ? (<Redirect to="/home"/>): (undefined)}
                    <img src="https://cdn.discordapp.com/attachments/361913998851178507/463173846007152641/logo_do_petter_white.png" width="100%"/>
                    <div className="login-form-container-group">
                        <h2>Login</h2>
                        <Label for="email">Email</Label>
                        <Input
                            type="email"
                            id="email"
                            placeholder="email@here"
                            onChange={this.handleChange}
                            name="email"
                        />

                        <Label for="password">Password</Label>
                        <Input
                            type="password"
                            id="password"
                            placeholder="senha aqui!"
                            onChange={this.handleChange}
                            name="password"
                        />
                        <div className="login-form-container-button-group">
                            <Button color="success" onClick={this.onLogin}>
                                Login
                            </Button>
                            <Button color="primary" onClick={this.toRegister}>
                                Register
                            </Button>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}