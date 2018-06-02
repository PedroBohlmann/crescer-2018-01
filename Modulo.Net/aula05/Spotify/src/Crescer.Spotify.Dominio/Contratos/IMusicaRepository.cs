using System.Collections.Generic;
using Crescer.Spotify.Dominio.Entidades;

namespace Crescer.Spotify.Dominio.Contratos
{
    public interface IMusicaRepository
    {
        void SalvarMusica(int idAlbum, Musica musica);
        void AtualizarMusica(int idAlbum, int id, Musica musica);
        void DeletarMusica(int idAlbum, int id);
        List<Musica> ListarMusicas(int idAlbum);             
        Musica Obter(int id);
    }
}