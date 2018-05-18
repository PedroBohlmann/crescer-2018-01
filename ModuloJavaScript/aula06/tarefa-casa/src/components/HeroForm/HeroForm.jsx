import React from 'react'

import Button from '../generic/Button/Button'
import Input from '../generic/Input/Input'
import Select from '../generic/Select/Select'

export default class HeroForm extends React.Component{

    constructor(){
        super()
        this.handdleChange = this.handdleChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
        this.state = this.getInitialState()
        this.clearForm = this.clearForm.bind(this)
    }

    onSubmit(e){
        e.preventDefault()
        this.props.onSubmitForm(this.state)
        this.clearForm()
    }

    handdleChange(e){
        const target = e.target
        const name = target.name
        const value = target.value

        this.setState({
            [name]:value
        })
    }

    optionsTeams(){
        return [
            {
            value:'Avengers',
            text:'Avengers'
            },
            {
            value:'Justice League',
            text:'Justice League'
            },
            {
            value:'X-Men',
            text:'X-Men'
            },
            {
            value:'Fantastic Four',
            text:'Fantastic Four'
            },
        ]
    }

    getInitialState(){
        return{
            name:'',
            alterEgo:'',
            team: this.optionsTeams()[0].value // arrumar reset
        }
    }

    clearForm(){
        this.setState(this.getInitialState())
    }


    render(){
        return (
            <div className="container col-6">
                <form onSubmit={this.onSubmit}> 
                    <Input id="name" type="text" name="name" placeholder="name aqui!" label="Nome" handdleChange={this.handdleChange} value={this.state.name}/>
                    <Input id="alterEgo" type="text" name="alterEgo" placeholder="alter-ego aqui!" label="Alter-Ego" handdleChange={this.handdleChange} value={this.state.alterEgo}/>
                    <Select id="team" name="team" label="Time" options={this.optionsTeams()} handdleChange={this.handdleChange} value={this.state.team} text="Selecione seu time"/>
                    <div className="btn-group float-right">
                        <Button type="button" text="Limpar" typeButton="btn-success" onClick={this.clearForm}/>
                        <Button type="submit" text="Inserir" typeButton="btn-primary" onClick={this.onSubmit}/>
                    </div>
                </form>
            </div>
        )
    }
}