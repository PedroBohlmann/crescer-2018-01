using System.Collections.Generic;
using Crescer.Spotify.Dominio.Entidades;
using Crescer.Spotify.Dominio.Servicos;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Crescer.Spotify.Dominio.Tests
{
    [TestClass]
    public class AvaliacaoServiceTest
    {
        [TestMethod]
        public void TestaAvaliacaoSemIdUsuario()
        {
            var avalicaoService = new AvaliacaoService();

            var musica = new Musica("nome",20);

            Avaliacao avaliacao = new Avaliacao(musica,null,3);

            var erros = avalicaoService.Validar(avaliacao);

            CollectionAssert.AreEqual(new List<string> { "IdUsuario é um campo obrigatorio" }, erros);
        }

        [TestMethod]
        public void TestaAvaliacaoSemIdMusica()
        {
            var avalicaoService = new AvaliacaoService();

            var usuario = new Usuario("usuario show");

            Avaliacao avaliacao = new Avaliacao(null,usuario,3);

            var erros = avalicaoService.Validar(avaliacao);

            CollectionAssert.AreEqual(new List<string> { "IdMusica é um campo obrigatorio" }, erros);
        }

        [TestMethod]
        public void TestaAvaliacaoSemNota()
        {
            var avalicaoService = new AvaliacaoService();

            var musica = new Musica("nome",20);

            var usuario = new Usuario("usuario show");

            Avaliacao avaliacao = new Avaliacao(musica,usuario,55);

            var erros = avalicaoService.Validar(avaliacao);

            CollectionAssert.AreEqual(new List<string> { "Nota que precisa estar entre 0 e 5" }, erros);
        }
    }
}