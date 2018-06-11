import CONFIG from "../config";

import axios from "axios";

import jwt_decode from 'jwt-decode'

export default class UsuarioService {
  static cadastro(usuario) {
    var data = {
      primeiroNome: usuario.primeiroNome,
      ultimoNome: usuario.ultimoNome,
      cpf: usuario.cpf,
      dataNascimento: usuario.dataNascimento,
      email: usuario.email,
      senha: usuario.senha
    };
    return axios.post(`${CONFIG.API_URL_BASE}/usuario`, data)
  }
  static login(login) {
    var data = {
      email: login.email,
      senha: login.senha
    }
    return axios.post(`${CONFIG.API_URL_BASE}/usuario/login`, data)
  }

  static getTokenInfo() {
    let decoded;
    if(localStorage.token!==null||localStorage.token!==""){
      decoded = jwt_decode(localStorage.token);
    }
    return decoded
  }
}
