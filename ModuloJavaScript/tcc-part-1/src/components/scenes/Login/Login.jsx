import React from 'react'

import { InputGroup, InputGroupAddon, InputGroupText, Input, Label, Button } from 'reactstrap';

import './Login.css'

export default class Login extends React.Component{

    constructor(){
        super()
        this.state = {
            email:'',
            password:''
        }
        this.handleChange=this.handleChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
    }

    onSubmit(e){
        console.log(this.state)
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
                <div className="login-form">
                    <Label for="email">Email</Label>
                    <Input type="email" id="email" placeholder="email@here" onChange={this.handleChange} name="email"/>

                    <Label for="password">Password</Label>
                    <Input type="password" id="password" placeholder="password here!" onChange={this.handleChange} name="password"/>
            
                    <Button color="success">Login</Button>
                </div>
            </div>
        )
    }
}