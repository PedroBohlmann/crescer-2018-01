import React from 'react'

export default class HeroSearchTableWithNoHeroes extends React.Component{
    render(){
        return (
            <div className="alert alert-secondary" role="alert">
                <h1 className="display-4">Você ainda não tem herois cadastrados!</h1>
                <p>Cadastra alguns ai pô!</p>
            </div>
        )
    }
}