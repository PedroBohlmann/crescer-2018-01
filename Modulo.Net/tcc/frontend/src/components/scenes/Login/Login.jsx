import React from "react";

import { Input, Label, Button } from "reactstrap";

import { Redirect } from "react-router-dom";

import "./Login.css";

import UsuarioService from "../../../service/UsuarioService";

export default class Login extends React.Component {
  constructor() {
    super();
    this.state = {
      email: "",
      senha: "",
      redirecionaHome: false,
      redirecionaCadastro: false
    };
    this.handleChange = this.handleChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
    this.onClickCadastro = this.onClickCadastro.bind(this);
  }

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    this.setState({
      [name]: value
    });
  }

  onSubmit(e) {
    var login = {
      email: this.state.email,
      senha: this.state.senha
    };
    UsuarioService.login(login)
      .then(result => {
        localStorage.token = result.data.token;
      })
      .catch(error => {
        console.log(error);
      });
  }

  onClickCadastro(e) {
    this.setState({
      redirecionaCadastro: true
    });
  }

  render() {
    return (
      <div className="login-container">
        {this.state.redirecionaCadastro ? (
          <Redirect to="/cadastro" />
        ) : (
          undefined
        )}
        <div className="login-form">
          <div className="display-2 align-at-center">Login</div>
          <Label for="email">Email</Label>
          <Input
            type="email"
            id="email"
            placeholder="email@aqui"
            onChange={this.handleChange}
            name="email"
          />

          <Label for="senha">Password</Label>
          <Input
            type="password"
            id="senha"
            placeholder="senha aqui!"
            onChange={this.handleChange}
            name="senha"
          />

          <Button color="success" onClick={this.onSubmit}>
            Login
          </Button>
          <Button color="primary" onClick={this.onClickCadastro}>
            Cadastro
          </Button>
        </div>
      </div>
    );
  }
}
