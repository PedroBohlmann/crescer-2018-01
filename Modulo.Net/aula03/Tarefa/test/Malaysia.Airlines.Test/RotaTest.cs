using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
namespace Malaysia.Airlines.Test
{
    [TestClass]
    public class RotaTest
    {
        [TestMethod]
        public void TestaDistanciaEntreDoisPontos()
        {
            Ponto A = new Ponto(40.76, -73.984);
            Ponto B = new Ponto(41.89, 12.492);
            Rota rota = new Rota(A, B);

            double esperado = Math.Floor(4279.9454);
            double resultado = rota.DistanciaEmMilhas();

            Assert.AreEqual(esperado, resultado);
        }
    }
}
