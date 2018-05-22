import React, { Component } from 'react';
import './App.css';

import CustomNavbar from './components/CustomNavbar/CustomNavbar'
import Login from './components/scenes/Login/Login'
import PostList from './components/scenes/PostList/PostList'
import CreatePost from './components/scenes/CreatePost/CreatePost'
import Home from './components/scenes/Home/Home'
import Logout from './components/scenes/Logout/Logout'
import PostDetail from './components/scenes/PostDetail/PostDetail'
import EditPost from './components/scenes/EditPost/EditPost'

import { Switch, Route, Redirect} from 'react-router-dom'

class App extends Component {
  render() {
    return (
      <div className="App">
        <Switch>
          <Route path="/" exact component={Login}/>
          <Route path="/home" exact component={Home}/>
          <Route path="/create-new-post" exact component={CreatePost}/>
          <Route path="/post/:id?" component={PostDetail}/>
          <Route path="/logout" exact component={Logout}/>
          <Route path="/edit-post/:id?" exact component={EditPost}/>          
          <Redirect to="/"/>
        </Switch>
        </div>
    );
  }
}

export default App;
