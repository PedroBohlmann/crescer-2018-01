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

            Avaliacao avaliacao = null;//new Avaliacao(1,0,3);

            var erros = avalicaoService.Validar(avaliacao);

            CollectionAssert.AreEqual(new List<string> { "IdUsuario é um campo obrigatorio" }, erros);
        }

        [TestMethod]
        public void TestaAvaliacaoSemIdMusica()
        {
            var avalicaoService = new AvaliacaoService();

            Avaliacao avaliacao = null;//new Avaliacao(0,2,3);

            var erros = avalicaoService.Validar(avaliacao);

            CollectionAssert.AreEqual(new List<string> { "IdMusica é um campo obrigatorio" }, erros);
        }

        [TestMethod]
        public void TestaAvaliacaoSemIdAlbum()
        {
            var avalicaoService = new AvaliacaoService();

            Avaliacao avaliacao = null;//new Avaliacao(2,2,55);

            var erros = avalicaoService.Validar(avaliacao);

            CollectionAssert.AreEqual(new List<string> { "Nota que precisa estar entre 0 e 5" }, erros);
        }
    }
}