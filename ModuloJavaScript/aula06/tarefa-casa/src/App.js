import React, { Component } from 'react';
import './App.css';
import Button from '../src/components/generic/Button/Button';
import HeroForm from '../src/components/HeroForm/HeroForm';

class App extends Component {
  render() {
    return (
      <div className="App">
      <HeroForm/>
      </div>
    );
  }
}

export default App;