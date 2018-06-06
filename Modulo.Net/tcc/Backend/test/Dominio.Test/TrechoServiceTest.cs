using System;
using System.Collections.Generic;
using Dominio.Entidades;
using Dominio.Servicos;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Dominio.Test
{
    [TestClass]
    public class TrechoServiceTest
    {
        [TestMethod]
        public void TestandoCalculoDeDistancia()
        {
            var origem = new Local("New York","Ta no meio de Manhattan",40.76, -73.984);
            var destino = new Local("Roma","Ta no coliseu de Roma",41.89, 12.492);
            var trecho = new Trecho(origem, destino);

            double esperado = Math.Floor(4279.9454);
            double resultado = trecho.DistanciaTotal;

            Assert.AreEqual(esperado, resultado);
        }

        [TestMethod]
        public void TestandoDadosDeOrigemFaltando()
        {
            var erros = new List<string>();
            erros.Add("Campo Origem é obrigatorio");

            var destino = new Local("Roma","Ta no coliseu de Roma",41.89, 12.492);

            var trecho = new Trecho(null,destino);

            var trechoService = new TrechoService();

            var resultado = trechoService.Validar(trecho);

            CollectionAssert.AreEqual(erros,resultado);
        }

        [TestMethod]
        public void TestandoDadosDeDestinoFaltando()
        {
            var erros = new List<string>();
            erros.Add("Campo Destino é obrigatorio");

            var origem = new Local("New York","Ta no meio de Manhattan",40.76, -73.984);

            var trecho = new Trecho(origem,null);

            var trechoService = new TrechoService();

            var resultado = trechoService.Validar(trecho);

            CollectionAssert.AreEqual(erros,resultado);
        }
    }
}
