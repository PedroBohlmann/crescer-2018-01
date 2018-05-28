using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace Malaysia.Airlines.Test
{
    [TestClass]
    public class VooTest
    {
        [TestMethod]
        public void TestaCalculoValorTotalVooComAviaoTurboJato()
        {
            Ponto A = new Ponto(40.76, -73.984);
            Ponto B = new Ponto(41.89, 12.492);
            Rota rota = new Rota(A, B);

            Aviao aviao = new AviaoTurboJato("Ronaldo", 2, 300);

            Voo voo=new Voo(aviao,rota);

            double esperado=3851100;
            double obtido=voo.ValorTotalVoo();

            Assert.AreEqual(esperado,obtido);
        }

        [TestMethod]
        public void TestaCalculoValorTotalVooComAviaoTurboElice()
        {
            Ponto A = new Ponto(40.76, -73.984);
            Ponto B = new Ponto(41.89, 12.492);
            Rota rota = new Rota(A, B);

            Aviao aviao = new AviaoTurboElice("14bis", 4, 100);

            Voo voo=new Voo(aviao,rota);

            double esperado=2053920;
            double obtido=voo.ValorTotalVoo();

            Assert.AreEqual(esperado,obtido);
        }
    }
}