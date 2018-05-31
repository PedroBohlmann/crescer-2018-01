using System.Collections.Generic;
using SpotifyCrescer.Dominio.Model;

namespace SpotifyCrescer.Dominio.Contratos
{
    public interface IAlbumRepository
    {
        List<Album> TodosOsAlbums();

        void InsereNovoAlbum(Album album);

        Album BuscaAlbumPorId(int id);

        void RemoveAlbumPorId(int id);

        void AtualizaAlbum(Album album);

        void InsereMusicaEmAlbum(int id,Musica musica);

        Musica BuscaMusicaPorId(int idAlbum,int idMusica);

        void RemoveMusicaPorId(int idAlbum,int idMusica);

        void AtualizaMusica(Musica musica,int idAlbum);
    }
}