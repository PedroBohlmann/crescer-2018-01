import React from 'react'

import {Input, Label, Button } from 'reactstrap';
import LoginService from '../../../service/LoginService'

import { Redirect } from 'react-router-dom'

import './Login.css'

export default class Login extends React.Component{

    constructor(){
        super()
        this.state = {
            email:'',
            password:'',
            goHome:false
        }
        this.handleChange=this.handleChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
    }

    onSubmit(e){
        LoginService.login(this.state.email,this.state.password)
            .then((result)=>{
                localStorage.accessToken=result.data.accessToken
                localStorage.userName = this.state.email.split("@")[0]
                this.setState({
                    goHome:true
                })
            }).catch((error)=>{
                console.log(error)
            })
    }

    handleChange(event){
        const target = event.target
        const value = target.value
        const name = target.name
        this.setState({
            [name]: value
        })
    }

    render(){
        return (
            <div className="login-container">
                {this.state.goHome?<Redirect to="/home"/>:undefined}
                <div className="login-form">
                    <div className="display-2 align-at-center">Login</div>
                    <Label for="email">Email</Label>
                    <Input type="email" id="email" placeholder="email@here" onChange={this.handleChange} name="email"/>

                    <Label for="password">Password</Label>
                    <Input type="password" id="password" placeholder="password here!" onChange={this.handleChange} name="password"/>
            
                    <Button color="success" onClick={this.onSubmit}>Login</Button>
                </div>
            </div>
        )
    }
}