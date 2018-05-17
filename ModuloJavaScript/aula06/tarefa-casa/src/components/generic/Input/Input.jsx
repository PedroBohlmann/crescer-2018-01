import React from 'react'

export default class Input extends React.Component{
    render(){
        return(
            <div className="form-group">
                <label htmlFor={this.props.id}>{this.props.label}</label>
                <input
                    id={this.props.id}
                    type={this.props.type}
                    className="form-control"
                    name={this.props.name}
                    placeholder={this.props.placeholder} />
            </div>
        )
    }
}