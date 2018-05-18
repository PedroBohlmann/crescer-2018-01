import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

import RegisterForm from '../src/components/RegisterForm/RegisterForm'
import LoginForm from '../src/components/LoginForm/LoginForm'

const SELECTED_COMPONENTS={
  LOGIN:'LOGIN',
  REGISTER_SCREEN: 'REGISTERSCREEN'
}

class App extends Component {

  constructor(){
    super()
    this.state={
      selectedComponent: SELECTED_COMPONENTS.LOGIN
    }
    this.onClick=this.onClick.bind(this)
  }

  onClick(event) {
    let target = event.target
    this.setSelectedComponent(target.id)
  }

  setSelectedComponent(id){
    this.setState({
      selectedComponent:id
    })
  }

  renderContent(){
    if(this.state.selectedComponent===SELECTED_COMPONENTS.LOGIN){
      return <LoginForm onClick={this.onClick}/>
    }
    else if(this.state.selectedComponent===SELECTED_COMPONENTS.REGISTER_SCREEN){
      return <RegisterForm onClick={this.onClick}/>
    }
  }


  render() {
    return (
      <div className="App">
        {this.renderContent()}
      </div>
    );
  }
}

export default App;
