import React, { Component } from 'react';
import './App.css';

import RegisterForm from '../src/components/RegisterForm/RegisterForm'
import LoginForm from '../src/components/LoginForm/LoginForm'
import MovieTab from '../src/components/MoviesTab/MoviesTab'
import Loading from '../src/components/generic/Loading/Loading'

const SELECTED_COMPONENTS={
  LOGIN:'LOGIN',
  REGISTERSCREEN: 'REGISTERSCREEN',
  MOVIESTAB: 'MOVIESTAB'
}

class App extends Component {

  constructor(){
    super()
    this.state={
      selectedComponent: SELECTED_COMPONENTS.LOGIN,
      showLoading:false
    }
    this.onClickScreenChange=this.onClickScreenChange.bind(this)
    this.redirectTo=this.redirectTo.bind(this)
    this.toggleLoading=this.toggleLoading.bind(this)
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

  toggleLoading(){
    const showLoading=!this.state.showLoading
    this.setState({
      showLoading
    })
  }

  renderContent(){
    if(this.state.selectedComponent===SELECTED_COMPONENTS.LOGIN){
      return <LoginForm onClick={this.onClickScreenChange} redirectTo={this.redirectTo} toggleLoading={this.toggleLoading}/>
    }
    else if(this.state.selectedComponent===SELECTED_COMPONENTS.REGISTERSCREEN){
      return <RegisterForm onClick={this.onClickScreenChange} redirectTo={this.redirectTo} toggleLoading={this.toggleLoading}/>
    }
    else if(this.state.selectedComponent===SELECTED_COMPONENTS.MOVIESTAB){
      return <MovieTab redirectTo={this.redirectTo} toggleLoading={this.toggleLoading}/>
    }
  }


  render() {
    return (
      <div className="App">
        <Loading showLoading={this.state.showLoading}/>
        {this.renderContent()}
      </div>
    );
  }
}

export default App;
