import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import CustomNavbar from './components/CustomNavbar/CustomNavbar'

import { Switch, Route, Redirect, Link } from 'react-router-dom'

class App extends Component {
  render() {
    return (
      <div className="App">
        <CustomNavbar/>
        {/* TODO: fazer o switch com os routes */}
      </div>
    );
  }
}

export default App;
