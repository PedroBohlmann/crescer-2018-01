using System;
using System.Collections.Generic;
using System.Linq;
using SpotifyCrescer.Dominio.Contratos;
using SpotifyCrescer.Dominio.Model;

namespace SpotifyCrescer.Infra
{
    public class AlbumRepository : IAlbumRepository
    {
        private static List<Album> albums = new List<Album>();

        private static int idAlbum = 1;

        private static int idMusica = 1;

        public Album BuscaAlbumPorId(int id)
        {
            return albums.FirstOrDefault(produto => produto.Id == id);
        }

        public Musica BuscaMusicaPorId(int idAlbum, int idMusica)
        {
            var album = albums.FirstOrDefault(produto => produto.Id == idAlbum);
            var musica = album.Musicas.FirstOrDefault(musicaI=>musicaI.Id==idMusica);
            return musica;
        }

        public void InsereMusicaEmAlbum(int id, Musica musica)
        {
            var album = albums.FirstOrDefault(produto => produto.Id == id);
            musica.Id=idMusica++;
            album.Musicas.Add(musica);
        }

        public void InsereNovoAlbum(Album album)
        {
            album.Id = idAlbum++;
            albums.Add(album);
        }

        public void RemoveAlbumPorId(int id)
        {
            var album = albums.FirstOrDefault(produto => produto.Id == id);
            albums.Remove(album);
        }

        public void RemoveMusicaPorId(int idAlbum, int idMusica)
        {
            var album = albums.FirstOrDefault(produto => produto.Id == idAlbum);
            var musica = album.Musicas.FirstOrDefault(musicaI=>musicaI.Id==idMusica);
            album.Musicas.Remove(musica);
        }

        public List<Album> TodosOsAlbums()
        {
            return albums;
        }
    }
}
