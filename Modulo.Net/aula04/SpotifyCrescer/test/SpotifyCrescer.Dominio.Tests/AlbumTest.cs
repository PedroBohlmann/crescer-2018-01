using Microsoft.VisualStudio.TestTools.UnitTesting;
using SpotifyCrescer.Dominio.Model;
using SpotifyCrescer.Dominio.Service;

namespace SpotifyCrescer.Dominio.Tests
{
    [TestClass]
    public class AlbumTest
    {
        [TestMethod]
        public void Testa_Validacao_De_Um_Album_Invalido()
        {
            var album = new Album("");

            var musicaService = new AlbumService();

            Assert.AreEqual("O campo Nome está nulo", musicaService.VerificarInconsistencia(album)[0]);
        }

        [TestMethod]
        public void Testa_Validacao_De_Um_Album_Valido()
        {
            var album = new Album("Truco");

            var musicaService = new AlbumService();

            Assert.AreEqual(0,musicaService.VerificarInconsistencia(album).Count);
        }
    }
}