import React from 'react'

import LoginService from '../../../service/LoginService'

import { Switch, Route, Redirect} from 'react-router-dom'

export default class Logout extends React.Component{
    
    constructor(){
        super()
        this.state = {
            redirectToLogin:false
        }
    }
    
    componentDidMount(){
        this.resetTokenFromAPI()
    }

    resetTokenFromAPI(){
        LoginService.logout(localStorage.accessToken)
            .then((result)=>{
                localStorage.userName=''
                localStorage.accessToken=''
                this.setState({
                    redirectToLogin:true
                })
            }).catch((error)=>{
                console.log(error)
            })
    }
    
    render(){
        return <div>
            {this.state.redirectToLogin?<Redirect to="/"/>:undefined}
        </div>
    }
}