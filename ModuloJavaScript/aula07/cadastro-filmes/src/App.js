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
    this.onClickScreenChange=this.onClickScreenChange.bind(this)
    this.redirectTo=this.redirectTo.bind(this)
  }

  onClickScreenChange(event) {
    let target = event.target
    this.redirectTo(target.id)
  }

  redirectTo(id){
    this.setState({
      selectedComponent:id
    })
  }

  renderContent(){
    if(this.state.selectedComponent===SELECTED_COMPONENTS.LOGIN){
      return <LoginForm onClick={this.onClickScreenChange}/>
    }
    else if(this.state.selectedComponent===SELECTED_COMPONENTS.REGISTER_SCREEN){
      return <RegisterForm onClick={this.onClickScreenChange} redirect={this.redirectTo}/>
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
