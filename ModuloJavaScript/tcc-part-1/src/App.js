import React, { Component } from 'react';
import './App.css';

import CustomNavbar from './components/CustomNavbar/CustomNavbar'
import Login from './components/scenes/Login/Login'
import PostList from './components/scenes/PostList/PostList'
import PostEditor from './components/scenes/PostEditor/PostEditor'
import Home from './components/scenes/Home/Home'
import Logout from './components/scenes/Logout/Logout'
import PostDetail from './components/scenes/PostDetail/PostDetail'
import Success from './components/Success/Success'

import Loader from './components/Loader/Loader'
import Error from './components/Error/Error'

import axios from 'axios'

import { Switch, Route, Redirect} from 'react-router-dom'

class App extends Component {

  constructor(){
    super()
    this.configureInterceptors()
    this.state = {
      redirectToLogin:false,
      loader:false,
      error:'',
      showError:false,
      success:'',
      showSuccess:false
    }
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
        localStorage.accessToken=''
        localStorage.userName=''
      }
      self.setState({
        error:error.message,
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
          {this.state.redirectToLogin?<Redirect to="/"/>:undefined}
          {this.state.redirectToLogin=false}
          <Route path="/" exact component={Login}/>
          <Route path="/home" exact component={Home}/>
          <Route path="/post-editor/:id?" exact component={PostEditor}/>
          <Route path="/post/:id?" component={PostDetail}/>
          <Route path="/logout" exact component={Logout}/>       
          <Redirect to="/"/>
        </Switch>
        </div>
    );
  }
}

export default App;
