import React from 'react'

import HeroSearchTableRow from '../HeroSearchTableRow/HeroSearchTableRow'

export default class HeroSearchTable extends React.Component {
    
    renderHeroes(){
        return this.props.heroes.map((hero,index)=>{
            return <HeroSearchTableRow  key={index} hero={hero} onRemove={this.props.onRemove}/>
        })
    }
    
    render() {
        return (
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">Alter-Ego</th>
                        <th scope="col">Team</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    {this.renderHeroes()}
                </tbody>
            </table>
        )
    }
}