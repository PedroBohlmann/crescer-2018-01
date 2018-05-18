import React, { Component } from 'react';
import './App.css';
import HeroForm from '../src/components/HeroForm/HeroForm';
import HeroSearchForm from '../src/components/HeroSearchForm/HeroSearchForm'
import Loader from '../src/components/generic/Loader/Loader'

class App extends Component {

  constructor() {
    super()
    this.onSubmitForm = this.onSubmitForm.bind(this)
    this.onRemove = this.onRemove.bind(this)
    this.state = {
      heroes: [],
      loader: true
    }
    this.toggleLoader()
  }

  onSubmitForm(hero) {
    let heroes = this.state.heroes
    heroes.push(hero)
    this.setState({
      heroes
    })
    console.log(hero)
  }

  onRemove(heroToBeRemoved) {
    let heroes = this.state.heroes.filter(hero => {
      if (hero.name !== heroToBeRemoved.name && hero.alterEgo !== heroToBeRemoved.alterEgo && hero.team !== heroToBeRemoved.team) {
        return hero
      }
    })
    this.setState({
      heroes
    })
  }

  getShowLoader() {
    return this.state.loader
  }

  toggleLoader() {
    setTimeout(function () {
      this.setState({
        loader: false
      })
    }.bind(this), 5000);
  }

  render() {
    return (
      <div className="App">
        {this.getShowLoader() ? <Loader /> :
          <div className="row">
            <HeroForm onSubmitForm={this.onSubmitForm} />
            <HeroSearchForm heroes={this.state.heroes} onRemove={this.onRemove} />
          </div>}
      </div>
    );
  }
}

export default App;