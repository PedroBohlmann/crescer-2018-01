import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import CustomNavbar from './components/CustomNavbar/CustomNavbar'
import Login from './components/scenes/Login/Login'

import { Switch, Route, Redirect, Link } from 'react-router-dom'

class App extends Component {
  render() {
    return (
      <div className="App">
        <CustomNavbar/>
        <Switch>
          <Route path="/" exact component={Login}/>
          <Redirect to="/"/>
        </Switch>
        </div>
    );
  }
}

export default App;
