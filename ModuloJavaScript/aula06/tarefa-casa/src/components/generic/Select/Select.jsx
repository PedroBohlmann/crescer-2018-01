import React from 'react'

export default class Select extends React.Component{

    renderOptions(){
        let first =true
        return this.props.options.map((option,key)=>{
            if(first){
                first=false
                return <option defaultValue="default" disabled selected>{this.props.text}</option>
            }
            return <option key={key} value={option.value}>{option.text}</option>
        
        })
    }

    render(){
        return(
            <div className="form-group">
            <label htmlFor={this.props.id}>{this.props.label}</label>
                <select name={this.props.name} id={this.props.id} className="form-control" onChange={this.props.handdleChange}>
                    {this.renderOptions()}
                </select>
            </div>
        )
    }
}