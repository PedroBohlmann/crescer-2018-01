import React from 'react'

export default class Button extends React.Component{

    createButtonClass(){
        return "btn "+ this.props.typeButton
    }

    render(){
        return(
            <button type={this.props.type} id={this.props.id}
            className={this.createButtonClass()}
            onClick={this.props.onClick}
            >
            {this.props.text}
            </button>
        )
    }
}