import React from 'react'

import capitaoAmerica from '../../assets/capitain.png'
import hulk from '../../assets/hulk.png'
import iron from '../../assets/iron.png'
import spider from '../../assets/spider.png'

import Heroi from '../Heroi/Heroi'

export default class Avenger extends React.Component{

    render(){
        return <div className="app">
            <div className="herois-container">
                <Heroi heroi={capitaoAmerica}/>
                <Heroi heroi={hulk}/>
                <Heroi heroi={iron}/>
                <Heroi heroi={spider}/>
            </div>
        </div>
    }
}