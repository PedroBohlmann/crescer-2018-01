using System.Collections.Generic;
using Crescer.Spotify.Dominio.Entidades;

namespace Crescer.Spotify.Dominio.Contratos
{
    public interface IAvaliacaoRepository
    {
        bool VerificaSeExisteAlgumaAvaliacao(Avaliacao avaliacao);
        void AtualizarAvaliacao(Avaliacao avaliacao);
        double? MediaAvaliacoes(int idMusica);
        void SalvarAvaliacao(Avaliacao avaliacao);

        double? AvaliacaoAlbum(int idAlbum);
    }
}