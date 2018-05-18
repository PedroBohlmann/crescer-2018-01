import React from 'react'

import Button from '../generic/Button/Button'
import Input from '../generic/Input/Input'

export default class RegisterForm extends React.Component{
    
    render(){
        return (
            <div className="d-flex justify-content-center">
                <form>
                    <Input type="email" placeholder="Email aqui!" name="email" id="email" label="Email"/>
                    <Input type="text" placeholder="Nome aqui!" name="name" id="name" label="Nome"/>
                    <Input type="password" placeholder="Senha aqui!" name="password" id="password" label="Senha"/>
                    <Button type="button" typeButton="btn-primary" text="Registrar-se"/>
                </form>
            </div>
        )
    }
}