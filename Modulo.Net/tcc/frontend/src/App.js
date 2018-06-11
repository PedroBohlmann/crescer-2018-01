import React, { Component } from 'react';
import axios from 'axios'
import './App.css';

import Login from './components/scenes/Login/Login';
import Cadastro from './components/scenes/Cadastro/Cadastro'
import Home from './components/scenes/Home/Home'
import LocalEditor from './components/scenes/LocalEditor/LocalEditor'
import Logout from './components/scenes/Logout/Logout'
import ClasseDeVooEditor from './components/scenes/ClasseDeVooEditor/ClasseDeVooEditor'
import OpcionalEditor from './components/scenes/OpcionalEditor/OpcionalEditor'
import TrechoEditor from './components/scenes/TrechoEditor/TrechoEditor'

import Loader from './components/Loader/Loader'
import Error from './components/Error/Error'
import Success from './components/Success/Success'

import { Switch, Route, Redirect} from 'react-router-dom'

class App extends Component {

  constructor(){
    super()
    this.state = {
      loader:false,
      error:'',
      showError:false,
      success:'',
      showSuccess:false,
    }
    this.configureInterceptors()
  }
  configureInterceptors(){
    const self=this

    axios.interceptors.request.use((config) => {
      self.toogleLoader()
      return config
    });

    axios.interceptors.response.use((response)=>{
      self.toogleLoader()
      self.setState({
        success:response.message,
        showSuccess:true
      })
      setTimeout(() => {
        self.setState({
          showSuccess:false
        })
      }, 3000);
      return response
    },(error)=>{
      if(error.response.status === 401){
        self.setState({
          redirectToLogin:true
        })
        localStorage.token=''
      }
      self.setState({
        error:error.response.data,
        showError:true
      })
      setTimeout(() => {
        self.setState({
          showError:false
        })
      }, 5000);
      self.toogleLoader()
      return error
    })
  }

  toogleLoader(){
    let loader= !this.state.loader
    this.setState({
      loader
    })
  }

  render() {
    return (
      <div className="App">
        <div className="messages">
          {this.state.showError?<Error text={this.state.error}/>:undefined}
          {this.state.showSuccess?<Success text={this.state.success}/>:undefined} 
        </div>       
        {this.state.loader?<Loader/>:undefined}
        <Switch>
          <Route path="/" exact component={Login}/>
          <Route path="/cadastro" exact component={Cadastro}/>
          <Route path="/home" exact component={Home}/>
          <Route path="/localEditor" exact component={LocalEditor}/>
          <Route path="/logout" exact component={Logout}/>
          <Route path="/classeDeVooEditor" exact component={ClasseDeVooEditor}/>
          <Route path="/trechoEditor" exact component={TrechoEditor}/>
          <Route path="/opcionalEditor" exact component={OpcionalEditor}/>
          <Redirect to="/"/>
        </Switch>
      </div>
    );
  }
}

export default App;
