using System;
using System.Collections.Generic;
using Dominio.Entidades;
using Dominio.Servicos;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Dominio.Test
{
    [TestClass]
    public class UsuarioServiceTest
    {
        [TestMethod]
        public void TestandoUsuarioComSenhaInvalida()
        {
            var usuario = new Usuario("Pedroka","Silva","12345678910",DateTime.Today,"pedroka@gmail.com","");

            var usuarioService = new UsuarioService();

            var erros = usuarioService.Validar(usuario);

            var mensagens = new List<string>();

            mensagens.Add("Senha é obrigatorio");

            CollectionAssert.AreEqual(mensagens,erros);
        }
        [TestMethod]
        public void TestandoUsuarioSemNome()
        {
            var usuario = new Usuario("","","12345678910",DateTime.Today,"pedroka@gmail.com","1233213");

            var usuarioService = new UsuarioService();

            var erros = usuarioService.Validar(usuario);

            var mensagens = new List<string>();

            mensagens.Add("Primeiro nome é obrigatorio");
            mensagens.Add("Ultimo nome é obrigatorio");

            CollectionAssert.AreEqual(mensagens,erros);
        }
    }
}