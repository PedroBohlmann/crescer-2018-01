import React from 'react'

export default class Login extends React.Component{

    constructor(){
        super()
        this.state = {
            emial:'',
            password:''
        }
    }

    onSubmit(e){
        console.log(this.state)
    }

    handleChange(){
        const target = event.target
        const value = target.value
        const name = target.name
        this.setState({
            [name]: value
        })
    }

    render(){
        return (
            <div>
                
            </div>
        )
    }
}