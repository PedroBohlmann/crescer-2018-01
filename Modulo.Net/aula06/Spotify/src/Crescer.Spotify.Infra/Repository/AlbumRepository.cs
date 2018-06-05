using System.Collections.Generic;
using System.Linq;
using Crescer.Spotify.Dominio.Contratos;
using Crescer.Spotify.Dominio.Entidades;
using Dapper;
using LojinhaDoCrescer.Infra;
using Microsoft.EntityFrameworkCore;

namespace Crescer.Spotify.Infra.Repository
{
    public class AlbumRepository : IAlbumRepository
    {

        private SpotifyContext contexto;

        public AlbumRepository(SpotifyContext spotifyContext)
        {
            this.contexto = spotifyContext;
        }
        public void AtualizarAlbum(int id, Album album)
        {
            var albumCadastrado = contexto.Albuns.FirstOrDefault(p => p.Id == id);
            albumCadastrado.Atualizar(album);
        }

        public void DeletarAlbum(int id)
        {
            var albumCadastrado = contexto.Albuns.Include(p => p.Musicas).FirstOrDefault(p => p.Id == id);
            contexto.Albuns.Remove(albumCadastrado);
        }

        public List<Album> ListarAlbum()
        {
            return contexto.Albuns.AsNoTracking().Include(p => p.Musicas).ToList();
        }

        public Album Obter(int id)
        {
            return contexto.Albuns
                            .Include(p => p.Musicas)
                            .AsNoTracking()
                            .FirstOrDefault(p => p.Id == id);
        }

        public Album SalvarAlbum(Album album)
        {
            contexto.Albuns.Add(album);
            return album;
        }
    }
}