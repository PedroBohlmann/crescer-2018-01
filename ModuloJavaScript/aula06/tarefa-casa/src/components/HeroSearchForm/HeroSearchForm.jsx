import React from 'react'

import Input from '../generic/Input/Input'

import HeroSearchTable from '../HeroSearchTable/HeroSearchTable'

export default class HeroSearchForm extends React.Component{

    render(){
        return(
            <div className="container col-6">
                <form>
                    <Input id="name" type="text" name="name" placeholder="Digite para pesquisar" label="Pesquisar"/>
                </form>
                <HeroSearchTable heroes={this.props.heroes} onRemove={this.props.onRemove}/>
            </div>
        )
    }
}