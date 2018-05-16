import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

import NoticiaItem from './components/NoticiaItem/NoticiaItem'

class App extends Component {
  render() {
    return (
      <div>
        <header class="header">
            <div>
                <h1 class="header-title">Globo esporte</h1>
            </div>
        </header>
        <div className="App">
          {/* chama noticia item  */}
        </div>
      </div>
    );
  }
}

export default App;