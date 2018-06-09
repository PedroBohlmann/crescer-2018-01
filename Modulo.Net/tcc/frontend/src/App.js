import React, { Component } from 'react';
import './App.css';

import Login from './components/scenes/Login/Login';
import Cadastro from './components/scenes/Cadastro/Cadastro'
import Home from './components/scenes/Home/Home'
import LocalEditor from './components/scenes/LocalEditor/LocalEditor'
import Logout from './components/scenes/Logout/Logout'
import ClasseDeVooEditor from './components/scenes/ClasseDeVooEditor/ClasseDeVooEditor'

import { Switch, Route, Redirect} from 'react-router-dom'

class App extends Component {
  render() {
    return (
      <div className="App">
        <Switch>
          <Route path="/" exact component={Login}/>
          <Route path="/cadastro" exact component={Cadastro}/>
          <Route path="/home" exact component={Home}/>
          <Route path="/localEditor" exact component={LocalEditor}/>
          <Route path="/logout" exact component={Logout}/>
          <Route path="/classeDeVooEditor" exact component={ClasseDeVooEditor}/>
          <Redirect to="/"/>
        </Switch>
      </div>
    );
  }
}

export default App;
