using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace Malaysia.Airlines.Test
{
    [TestClass]
    public class AviaoTest
    {
        [TestMethod]
        public void TestaCalculoValorBaseAviaoJato()
        {
            Aviao aviao = new AviaoTurboJato("Ronaldo", 2, 300);

            double esperado = 900;
            double obtido = aviao.CalculaValorBase();

            Assert.AreEqual(esperado, obtido);
        }

        [TestMethod]
        public void TestaCalculoValorBaseAviaoElice()
        {
            Aviao aviao = new AviaoTurboElice("14bis", 4, 100);

            double esperado = 480;
            double obtido = aviao.CalculaValorBase();

            Assert.AreEqual(esperado, obtido);
        }
    }
}