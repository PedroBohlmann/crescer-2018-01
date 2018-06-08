import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

import Login from './components/scenes/Login/Login';
import Cadastro from './components/scenes/Cadastro/Cadastro'

import { Switch, Route, Redirect} from 'react-router-dom'

class App extends Component {
  render() {
    return (
      <div className="App">
        <Switch>
          <Route path="/" exact component={Login}/>
          <Route path="/cadastro" exact component={Cadastro}/>  
          <Redirect to="/"/>
        </Switch>
      </div>
    );
  }
}

export default App;
