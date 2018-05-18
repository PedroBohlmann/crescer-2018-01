import React from 'react'

import Input from '../generic/Input/Input'

import HeroSearchTable from '../HeroSearchTable/HeroSearchTable'
import HeroSearchTableWithNoHeroes from '../HeroSearchTableWithNoHeroes/HeroSearchTableWithNoHeroes'

export default class HeroSearchForm extends React.Component{

    toggleView(){
        return this.props.heroes.length>0
    }

    render(){
        return(
            <div className="container col-6">
                <form>
                    <Input id="name" type="text" name="name" placeholder="Digite para pesquisar" label="Pesquisar"/>
                </form>
                {this.toggleView()?
                <HeroSearchTable heroes={this.props.heroes} onRemove={this.props.onRemove}/>:
                <HeroSearchTableWithNoHeroes/>
                }
            </div>
        )
    }
}