using System;
using System.Collections.Generic;
using Dominio.Entidades;
using Dominio.Servicos;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Dominio.Test
{
    [TestClass]
    public class TrechoTest
    {
        [TestMethod]
        public void TestandoCalculoDeDistancia()
        {
            var trecho = new Trecho(40.76, -73.984, 41.89, 12.492);

            double esperado = Math.Floor(4279.9454);
            double resultado = trecho.DistanciaTotal;

            Assert.AreEqual(esperado, resultado);
        }

        [TestMethod]
        public void TestandoDadosDeOrigemFaltando()
        {
            var erros = new List<string>();
            erros.Add("LatitudeOrigem é um campo obrigatorio");
            erros.Add("LongitudeOrigem é um campo obrigatorio");

            var trecho = new Trecho(0,0,41.89, 12.492);

            var trechoService = new TrechoService();

            var resultado = trechoService.Validar(trecho);

            CollectionAssert.AreEqual(erros,resultado);
        }

        [TestMethod]
        public void TestandoDadosDeDestinoFaltando()
        {
            var erros = new List<string>();
            erros.Add("LatitudeDestino é um campo obrigatorio");
            erros.Add("LongitudeDestino é um campo obrigatorio");

            var trecho = new Trecho(41.89, 12.492,0,0);

            var trechoService = new TrechoService();

            var resultado = trechoService.Validar(trecho);

            CollectionAssert.AreEqual(erros,resultado);
        }
    }
}
