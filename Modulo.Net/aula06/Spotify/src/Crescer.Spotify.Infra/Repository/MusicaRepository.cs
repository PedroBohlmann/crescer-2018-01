using System;
using System.Collections.Generic;
using System.Linq;
using Crescer.Spotify.Dominio.Contratos;
using Crescer.Spotify.Dominio.Entidades;
using Dapper;
using LojinhaDoCrescer.Infra;
using Microsoft.EntityFrameworkCore;

namespace Crescer.Spotify.Infra.Repository
{
    public class MusicaRepository : IMusicaRepository//ARRUMAR ROTAS
    {

        private SpotifyContext contexto;

        public MusicaRepository(SpotifyContext contexto)
        {
            this.contexto = contexto;
        }

        public void AtualizarMusica(int idAlbum, int id, Musica musica)
        {
            var album = contexto.Albuns.Include(p => p.Musicas).FirstOrDefault(p => p.Id == idAlbum);

            var musicaAntes = album.Musicas.Find(p => p.Id == id);

            musicaAntes.Atualizar(musica);
        }

        public void DeletarMusica(int idAlbum, int id)
        {
            var album = contexto.Albuns.Include(p => p.Musicas).FirstOrDefault(p => p.Id == idAlbum);

            var musica = album.Musicas.Find(p => p.Id == id);

            contexto.Musicas.Remove(musica);
        }

        public List<Musica> ListarMusicas(int idAlbum)
        {
            return contexto.Albuns.AsNoTracking().Include(p => p.Musicas).FirstOrDefault(p => p.Id == idAlbum).Musicas;
        }

        public Musica Obter(int id)
        {
            return contexto.Musicas.AsNoTracking().FirstOrDefault(p => p.Id == id);
        }

        public void SalvarMusica(int idAlbum, Musica musica)
        {
            var albumCadastrado = contexto.Albuns.Include(p => p.Musicas).FirstOrDefault(p => p.Id == idAlbum);
            albumCadastrado.AdicionarMusica(musica);
        }
    }
}