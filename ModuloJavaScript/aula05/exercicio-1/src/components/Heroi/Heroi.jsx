import React from 'react'

export default class Heroi extends React.Component{

    render(){
        return <div className="heroi">
                    <img src={this.props.heroi} />
                </div>
    }
}