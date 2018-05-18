import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

import RegisterForm from '../src/components/RegisterForm/RegisterForm'

class App extends Component {
  render() {
    return (
      <div className="App">
        <RegisterForm/>
      </div>
    );
  }
}

export default App;
