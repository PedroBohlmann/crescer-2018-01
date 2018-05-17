import React from 'react'

export default class Button extends React.Component{

    createButtonClass(){
        return "btn "+ this.props.typeButton
    }

    render(){
        return(
            <button type={this.props.type} className={this.createButtonClass()}>
            {this.props.text}
            </button>
        )
    }
}