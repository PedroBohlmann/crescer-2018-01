import React from 'react'

import Button from '../generic/Button/Button'
import Input from '../generic/Input/Input'

export default class LoginForm extends React.Component{

    render(){
        return(
            <div className="d-flex justify-content-center">
                <form>
                    <h1 className="display-4">Login</h1>
                    <Input type="email" placeholder="Email aqui!" name="email" id="email" label="Email"/>
                    <Input type="password" placeholder="Senha aqui!" name="password" id="password" label="Senha"/>
                    <Button type="button" id="" typeButton="btn-primary" text="Logar"/>
                    <Button type="button" onClick={this.props.onClick} id="REGISTERSCREEN" typeButton="btn-primary" text="Registrar-se aqui"/>
                </form>
            </div>
        )
    }
} 