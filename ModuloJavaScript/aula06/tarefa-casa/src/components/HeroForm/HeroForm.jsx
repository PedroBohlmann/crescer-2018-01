import React from 'react'

import Button from '../generic/Button/Button'
import Input from '../generic/Input/Input'
import Select from '../generic/Select/Select'

export default class HeroForm extends React.Component{
    
    optionsTest(){
        return [
            {
            value:'1',
            text:'valor 1'
            },
        ]
    }

    render(){
        return (
            <div className="container col-6">
                <Input id="name" type="text" name="name" placeholder="name here" label="Name"/>
                <Input id="alterEgo" type="text" name="alterEgo" placeholder="alter-ego here" label="Alter-Ego"/>
                <Button type="button" text="insert" typeButton="btn-primary"/>
            </div>
        )
    }
}