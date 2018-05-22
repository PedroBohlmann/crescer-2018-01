import React, { Component } from 'react';
import './App.css';

import CustomNavbar from './components/CustomNavbar/CustomNavbar'
import Login from './components/scenes/Login/Login'
import PostList from './components/scenes/PostList/PostList'
import CreatePost from './components/scenes/CreatePost/CreatePost'

import { Switch, Route, Redirect} from 'react-router-dom'

class App extends Component {
  render() {
    return (
      <div className="App">
        <CustomNavbar/>
        <Switch>
          <Route path="/" exact component={Login}/>
          <Route path="/posts" exact component={PostList}/>
          <Route path="/create-new-post" exact component={CreatePost}/>
          <Redirect to="/"/>
        </Switch>
        </div>
    );
  }
}

export default App;
