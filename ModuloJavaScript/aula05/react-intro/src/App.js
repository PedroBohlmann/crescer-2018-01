import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Post from '../src/components/Post/Post'

class App extends Component {
  render() {
    return (
      <div className="App">
        <Post title="Truco" descricao="Mussum Ipsum, cacilds vidis litro abertis. Quem num gosta di mé, boa gentis num é. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Praesent vel viverra nisi. Mauris aliquet nunc non turpis scelerisque, eget. Tá deprimidis, eu conheço uma cachacis que pode alegrar sua vidis."/>
      </div>
    );
  }
}

export default App;
