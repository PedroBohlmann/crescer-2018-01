import React, { Component } from 'react';
import './App.css';

import Noticias from './components/Noticias/Noticias'
import Classificacao from './components/Classificacao/Classificacao'

class App extends Component {

  noticias() {
    return [
      {
        titulo: 'Ferguson pergunta por time do filho e faz piada sobre a Champions, diz jornal',
        descricao: 'Primeiras palavras do ex-técnico do United, internado desde sábado, teriam sido sobre futebol',
        categoria: 'futebol inglês ',
        tempo: '2 dias',
        imagem: 'https://s2.glbimg.com/ikTeV1IpLGrDZxvmnriRktnNCyI=/0x0:3500x2334/540x304/smart/http://i.s3.glbimg.com/v1/AUTH_bc8228b6673f488aa253bbcb03c80ec5/internal_photos/bs/2018/7/P/8awN8YQFeZHs4Xqej3fQ/2018-05-05t193830z-1062291551-rc1c507345c0-rtrmadp-3-soccer-england-mun-ferguson.jpg'
      },
      {
        titulo: 'Com dores no joelho direito, Daniel Alves fará exames nesta quarta e preocupa',
        descricao: 'Lateral brasileiro foi substituído no segundo tempo da vitória do PSG sobre o Les Herbiers, e pessoas próximas temem problema que o tire da Copa. Marquinhos tranquiliza: "Caminhou bem"',
        categoria: ' futebol francês ',
        tempo: '12 horas',
        imagem: 'https://s2.glbimg.com/S0sBhWxwp6g79MZNK4M5crEsTcY=/351x0:4866x2540/540x304/smart/http://s2.glbimg.com/2LjzbPkecYxWILV-jmK4Vh45Ftk=/275x1172:5568x3712/5293x2540/s.glbimg.com/es/ge/f/original/2018/05/08/000_14o4l6.jpg'
      },
      {
        titulo: 'Números da 4ª rodada: Grêmio ajuda no recorde de gols, goleiro do Bahia faz contra',
        descricao: 'Quantidade de gols surpreende, mas também chamam atenção no número de faltas cometidas, passes errados, cartões amarelos e vermelhos',
        categoria: ' grêmio',
        tempo: '1 hora',
        imagem: 'https://s2.glbimg.com/eS1xVCI-JNl7FlBwhX3dq9L6C9g=/0x113:2048x1266/540x304/smart/http://s.glbimg.com/es/ge/f/original/2018/05/08/28067718338_84c26ef4f3_k.jpg'
      }
    ]
  }

  classificacao() {
    return [
      {
        time: 'Grêmio',
        pontuacao: 99,
        posicao: 1
      },
      {
        time: 'Brasil',
        pontuacao: 10,
        posicao: 2
      },
      {
        time: 'Inter',
        pontuacao: 0,
        posicao: 3
      }
    ]
  }

  render() {
    return (
      <div>
        <header className="header">
          <div>
            <h1 className="header-title">Globo esporte</h1>
          </div>
        </header>
        <div className="App">
          <Noticias noticias={this.noticias()} />
          <Classificacao times={this.classificacao()}/>
        </div>

      </div>
    );
  }
}

export default App;