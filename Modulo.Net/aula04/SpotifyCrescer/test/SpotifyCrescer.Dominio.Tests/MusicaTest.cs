using Microsoft.VisualStudio.TestTools.UnitTesting;
using SpotifyCrescer.Dominio.Model;
using SpotifyCrescer.Dominio.Service;

namespace SpotifyCrescer.Dominio.Tests
{
    [TestClass]
    public class MusicaTest
    {
        [TestMethod]
        public void Testa_Validacao_de_Musica_Sem_Nome()
        {
            var musica = new Musica("", 30);

            var musicaService = new MusicaService();

            var resultado = musicaService.VerificarInconsistencia(musica);

            Assert.AreEqual("O campo Nome está nulo", resultado[0]);
        }

        [TestMethod]
        public void Testa_Validacao_de_Musica_Sem_Duracao()
        {
            var musica = new Musica("Musicao show", 0);

            var musicaService = new MusicaService();

            var resultado = musicaService.VerificarInconsistencia(musica);

            Assert.AreEqual("O campo Duracao está nulo", resultado[0]);
        }

        [TestMethod]
        public void Testa_Validacao_de_Musica_Valida()
        {
            var musica = new Musica("Musicao show", 30);

            var musicaService = new MusicaService();

            var resultado = musicaService.VerificarInconsistencia(musica);

            Assert.AreEqual(0, resultado.Count);
        }
    }
}
