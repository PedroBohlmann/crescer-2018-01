using System;
using System.Collections.Generic;
using Dominio.Entidades;
using Dominio.Servicos;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Dominio.Test
{
    [TestClass]
    public class ReservaServiceTest
    {
        [TestMethod]
        public void TestaServiceSemTrecho()
        {
            var classeVoo = new ClasseDeVoo("top", 500, 25);

            var usuario = new Usuario("Pedroka","Silva","12345678910",DateTime.Today,"pedroka@gmail.com","opa");

            var origem = new Local("New York", "Ta no meio de Manhattan", 40.76, -73.984);
            var destino = new Local("Roma", "Ta no coliseu de Roma", 41.89, 12.492);

            // var trecho = new Trecho(origem,destino);

            var reserva = new Reserva(classeVoo, null,usuario);

            var reservaService = new ReservaService();

            var resultado = reservaService.Validar(reserva);

            var erros = new List<string>();

            erros.Add("Trecho é um campo obrigatorio");

            CollectionAssert.AreEqual(erros, resultado);
        }

        [TestMethod]
        public void TestaServiceSemClasseDeVoo()
        {
            var usuario = new Usuario("Pedroka","Silva","12345678910",DateTime.Today,"pedroka@gmail.com","opa");
            var origem = new Local("New York", "Ta no meio de Manhattan", 40.76, -73.984);
            var destino = new Local("Roma", "Ta no coliseu de Roma", 41.89, 12.492);

            var trecho = new Trecho(origem, destino);

            var reserva = new Reserva(null, trecho,usuario);

            var reservaService = new ReservaService();

            var resultado = reservaService.Validar(reserva);

            var erros = new List<string>();

            erros.Add("ClasseDeVoo é um campo obrigatorio");

            CollectionAssert.AreEqual(erros, resultado);
        }

        [TestMethod]
        public void TestaServiceCalculoValorTotal()
        {
            var usuario = new Usuario("Pedroka","Silva","12345678910",DateTime.Today,"pedroka@gmail.com","opa");
            var classeVoo = new ClasseDeVoo("top", 500, 25);

            var origem = new Local("New York", "Ta no meio de Manhattan", 40.76, -73.984);
            var destino = new Local("Roma", "Ta no coliseu de Roma", 41.89, 12.492);//4279

            var trecho = new Trecho(origem, destino);

            var reserva = new Reserva(classeVoo, trecho,usuario);

            var valorTotalResultado = reserva.ValorTotal;

            var valorEsperado = 107475;

            Assert.AreEqual(valorEsperado,valorTotalResultado);
        }
    }
}