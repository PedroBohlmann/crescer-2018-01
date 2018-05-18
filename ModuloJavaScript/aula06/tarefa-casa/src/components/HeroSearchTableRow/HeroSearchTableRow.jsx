import React from 'react'

import Button from '../generic/Button/Button'

export default class HeroSearchTableRow extends React.Component{
    
    render(){
        return (
        <tr>
            <td>{this.props.hero.name}</td>
            <td>{this.props.hero.alterEgo}</td>
            <td>{this.props.hero.team}</td>
            <td><Button type="button" text="remove" typeButton="btn-danger" onClick={()=>this.props.onRemove(this.props.hero)}/></td>
        </tr>
        )
    }
}