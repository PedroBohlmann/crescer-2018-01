using System;
using System.Collections.Generic;
using Dominio.Entidades;
using Dominio.Servicos;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Dominio.Test
{
    [TestClass]
    public class LocalServiceTest
    {
        [TestMethod]
        public void TestandoLocalSemCidade()
        {
            var mensagens = new List<string>();

            mensagens.Add("Campo cidade é obrigatorio");

            var localService = new LocalService();

            var local=new Local("","aeroloko",55,66);

            var resultado = localService.Validar(local);

            CollectionAssert.AreEqual(mensagens,resultado);
        }

        [TestMethod]
        public void TestandoLocalSemAeroporto()
        {
            var mensagens = new List<string>();

            mensagens.Add("Campo aeroporto é obrigatorio");

            var localService = new LocalService();

            var local=new Local("Nunca nem vi","",55,66);

            var resultado = localService.Validar(local);

            CollectionAssert.AreEqual(mensagens,resultado);
        }

        [TestMethod]
        public void TestandoLocalComLatitudeInvalida()
        {
            var mensagens = new List<string>();

            mensagens.Add("Latitude varia de -90 até 90");

            var localService = new LocalService();

            var local=new Local("Nunca nem vi","Um que tem aviao",95,66);

            var resultado = localService.Validar(local);

            CollectionAssert.AreEqual(mensagens,resultado);
        }
        [TestMethod]
        public void TestandoLocalComLongitudeInvalida()
        {
            var mensagens = new List<string>();

            mensagens.Add("Longitude varia de -180 até 180");

            var localService = new LocalService();

            var local=new Local("Nunca nem vi","Um que tem aviao",85,186);

            var resultado = localService.Validar(local);

            CollectionAssert.AreEqual(mensagens,resultado);
        }
    }
}