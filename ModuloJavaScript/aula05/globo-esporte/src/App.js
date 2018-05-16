import React, { Component } from 'react';
import './App.css';

import NoticiaItem from './components/NoticiaItem/NoticiaItem'
import Classificao from './components/Classificao/Classificao'

class App extends Component {
  render() {
    return (
      <div>
        <header className="header">
            <div>
                <h1 className="header-title">Globo esporte</h1>
            </div>
        </header>
        <div className="App">
          <div className="noticia">
            <NoticiaItem src="https://s2.glbimg.com/QcwXbnLdovzmbcCaqAId9k7r7DI=/0x0:1200x900/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_bc8228b6673f488aa253bbcb03c80ec5/internal_photos/bs/2018/z/f/ZDXoEVS9WiHUqByBtyWQ/dcscfk4x0aajfge.jpg"/>
          </div>
          <Classificao/>
        </div>

      </div>
    );
  }
}

export default App;