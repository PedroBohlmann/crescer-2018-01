using System;
using System.Collections.Generic;
using Dominio.Entidades;
using Dominio.Servicos;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Dominio.Test
{
    [TestClass]
    public class OpcionalServiceTest
    {
        [TestMethod]
        public void TestaOpcionalComValorInvalido()
        {
            var optional = new Opcional("Open bar de chá","Open bar de chá gelado",666);
            
            var erros = new List<string>();
            erros.Add("O valor porcentagem precisa estar entre 0 e 1");

            var optionalService = new OpcionalService();

            var resultado = optionalService.Validar(optional);

            CollectionAssert.AreEqual(erros,resultado);
        }

        [TestMethod]
        public void TestaOpcionalComNomeInvalido()
        {
            var optional = new Opcional("","Open bar de chá gelado",0.6);
            
            var erros = new List<string>();
            erros.Add("Campo nome é obrigatorio");

            var optionalService = new OpcionalService();

            var resultado = optionalService.Validar(optional);

            CollectionAssert.AreEqual(erros,resultado);
        }

        [TestMethod]
        public void TestaOpcionalComDescricaoInvalida()
        {
            var optional = new Opcional("Open bar de chá","",0.6);
            
            var erros = new List<string>();
            erros.Add("Campo descrição é obrigatorio");

            var optionalService = new OpcionalService();

            var resultado = optionalService.Validar(optional);

            CollectionAssert.AreEqual(erros,resultado);
        }

        [TestMethod]
        public void TestaOptionalValido()
        {
            var optional = new Opcional("Open bar de chá","Open bar de chá gelado",0.6);
            
            var erros = new List<string>();

            var optionalService = new OpcionalService();

            var resultado = optionalService.Validar(optional);

            CollectionAssert.AreEqual(erros,resultado);
        }
    }
}