import React, { Component } from 'react';
import './App.css';

import { Switch, Route, Redirect} from 'react-router-dom'

import Login from './components/scenes/Login/Login';
import Home from './components/scenes/Home/Home';
import Register from './components/scenes/Register/Register';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Switch>
          <Route path="/" exact component={Login}/>
          <Route path="/home" exact component={Home}/>
          <Route path="/register" exact component={Register}/>
          <Redirect to="/"/>
        </Switch>
      </div>
    );
  }
}

export default App;
