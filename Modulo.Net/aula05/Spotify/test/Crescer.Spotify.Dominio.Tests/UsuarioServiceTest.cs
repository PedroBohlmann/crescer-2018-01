using System.Collections.Generic;
using Crescer.Spotify.Dominio.Entidades;
using Crescer.Spotify.Dominio.Servicos;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Crescer.Spotify.Dominio.Tests
{
    [TestClass]
    public class UsuarioServiceTest
    {
        [TestMethod]
        public void TestaSeRetonaErrosSeNomeNaoForInformado()
        {
            var usuarioService= new UsuarioService();

            var erros=usuarioService.Validar(new Usuario(""));

            CollectionAssert.AreEqual(new List<string>{"É preciso informar o campo nome do usuario"},erros);
        }

        [TestMethod]
        public void TestaSeNaoRetonaErrosSeNomeForInformado()
        {
            var usuarioService= new UsuarioService();

            var erros=usuarioService.Validar(new Usuario("pedroca"));

            CollectionAssert.AreEqual(new List<string>{},erros);
        }
    }
}