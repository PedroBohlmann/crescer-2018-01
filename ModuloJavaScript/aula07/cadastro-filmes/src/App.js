import React, { Component } from 'react';
import './App.css';

import RegisterForm from '../src/components/RegisterForm/RegisterForm'
import LoginForm from '../src/components/LoginForm/LoginForm'

const SELECTED_COMPONENTS={
  LOGIN:'LOGIN',
  REGISTERSCREEN: 'REGISTERSCREEN'
  
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
    const target = event.target
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
    else if(this.state.selectedComponent===SELECTED_COMPONENTS.REGISTERSCREEN){
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
