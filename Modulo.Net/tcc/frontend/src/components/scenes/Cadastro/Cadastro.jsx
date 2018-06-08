import React from "react";

import { Input, Label, Button } from "reactstrap";

import { Redirect } from "react-router-dom";

import "./Cadastro.css";

import UsuarioService from "../../../service/UsuarioService";

export default class Cadastro extends React.Component {
  constructor() {
    super();
    this.state = {
      primeiroNome: "",
      ultimoNome: "",
      cpf: "",
      dataNascimento: "",
      senha: "",
      senhaConfimacao: "",
      redirecionarLogin: false
    };
    this.handleChange = this.handleChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
    this.onClickVoltarLogin = this.onClickVoltarLogin.bind(this);
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
    if (this.state.senha !== this.state.senhaConfimacao) return;
    var usuario = {
      primeiroNome: this.state.primeiroNome,
      ultimoNome: this.state.ultimoNome,
      cpf: this.state.cpf,
      dataNascimento: this.state.dataNascimento,
      email: this.state.email,
      senha: this.state.senha
    };
    UsuarioService.cadastro(usuario)
      .then(result => {
        console.log("cadastrou");
      })
      .catch(error => {
        console.log(error);
      });
  }

  onClickVoltarLogin(e) {
    this.setState({
      redirecionarLogin: true
    });
  }

  render() {
    return (
      <div className="cadastro-container">
        {this.state.redirecionarLogin ? <Redirect to="/" /> : undefined}
        <div className="cadastro-form">
          <div className="display-4 align-at-center">Cadastro</div>
          <Label for="primeiro-nome">Primeiro Nome</Label>
          <Input
            type="text"
            id="primeiro-nome"
            placeholder="Primeiro nome aqui"
            onChange={this.handleChange}
            name="primeiroNome"
          />

          <Label for="ultimo-nome">Ultimo Nome</Label>
          <Input
            type="text"
            id="ultimo-nome"
            placeholder="Ultimo nome aqui"
            onChange={this.handleChange}
            name="ultimoNome"
          />

          <Label for="cpf">Cpf</Label>
          <Input
            type="text"
            id="cpf"
            placeholder="Cpf nome aqui"
            onChange={this.handleChange}
            name="cpf"
          />
          <Label for="dataNascimento">Data nascimento</Label>
          <Input
            type="date"
            id="dataNascimento"
            onChange={this.handleChange}
            name="dataNascimento"
          />
          <Label for="email">Email</Label>
          <Input
            type="text"
            id="email"
            placeholder="email aqui"
            onChange={this.handleChange}
            name="email"
          />
          <Label for="senha">Senha</Label>
          <Input
            type="password"
            id="senha"
            placeholder="Senha aqui"
            onChange={this.handleChange}
            name="senha"
          />
          <Label for="senhaConfirmacao">Senha confimação</Label>
          <Input
            type="password"
            id="senhaConfirmacao"
            placeholder="Confime a senha aqui"
            onChange={this.handleChange}
            name="senhaConfimacao"
          />

          <Button color="success" onClick={this.onSubmit}>
            Cadastrar
          </Button>
          <Button color="primary" onClick={this.onClickVoltarLogin}>
            Voltar para login
          </Button>
        </div>
      </div>
    );
  }
}
