import React from 'react'

export default class Select extends React.Component{

    renderOptions(){
        return this.props.options.map((option,key)=>{
            return <option key={key} value={option.value}>{option.text}</option>
        
        })
    }

    render(){
        return(
            <div className="form-group">
            <label htmlFor={this.props.id}>{this.props.label}</label>
                <select name={this.props.name} id={this.props.id} className="form-control" onChange={this.props.handdleChange}>
                    <option defaultValue="default" disabled selected>Select your team</option>
                    {this.renderOptions()}
                </select>
            </div>
        )
    }
}