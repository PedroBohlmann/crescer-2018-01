using System;
using System.Collections.Generic;
using Dominio.Entidades;
using Dominio.Servicos;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Dominio.Test
{
    [TestClass]
    public class ClassesDeVooServiceTest
    {
        [TestMethod]
        public void TestaVooSemNome()
        {
            var voo = new ClasseDeVoo("", 50, 250);

            var erros = new List<string>();

            erros.Add("Descricao é um campo obrigatorio");

            var vooService = new ClasseDeVooService();

            var resultado = vooService.Validar(voo);

            CollectionAssert.AreEqual(resultado, erros);
        }

        [TestMethod]
        public void TestaVooSemValorFixo()
        {
            var voo = new ClasseDeVoo("dsa", 0, 250);

            var erros = new List<string>();

            erros.Add("Valor fixo é um campo obrigatorio");

            var vooService = new ClasseDeVooService();

            var resultado = vooService.Validar(voo);

            CollectionAssert.AreEqual(resultado, erros);
        }

        [TestMethod]
        public void TestaVooSemValorMilha()
        {
            var voo = new ClasseDeVoo("dsa", 50, 0);

            var erros = new List<string>();

            erros.Add("Valor milha é um campo obrigatorio");

            var vooService = new ClasseDeVooService();

            var resultado = vooService.Validar(voo);

            CollectionAssert.AreEqual(resultado, erros);
        }
    }
}