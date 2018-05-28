using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using Class;

namespace Calculadora.Test
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestMethod1()
        {
            CalculadoraQueFunciona calc=new CalculadoraQueFunciona();

            int resultado = calc.somar(1,1);

            int esperado = 2;

            Assert.AreEqual(esperado,resultado);            
        }
    }
}
