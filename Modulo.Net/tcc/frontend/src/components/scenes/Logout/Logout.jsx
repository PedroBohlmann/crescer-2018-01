import React from 'react'

import {Redirect} from 'react-router-dom'

import './Logout.css'

export default class Logout extends React.Component{

    constructor(){
        super()
        this.state={
            redirecionarParaLogin:false
        }
    }

    componentDidMount(){
        this.resetaToken()
    }


    resetaToken(){
        localStorage.token=""
        this.setState({
            redirecionarParaLogin:true
        })
    }

    render(){
        return(
            <div>
                <h1>Vlw flw</h1>
                {this.state.redirecionarParaLogin?<Redirect to="/"/>:undefined}
            </div>
        )
    }
}