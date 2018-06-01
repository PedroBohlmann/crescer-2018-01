using System;
using System.Collections.Generic;
using System.Linq;
using Crescer.Spotify.Dominio.Contratos;
using Crescer.Spotify.Dominio.Entidades;

namespace Crescer.Spotify.Infra.Repository
{
    public class MusicaRepository : IMusicaRepository
    {
        public void AtualizarMusica(int idAlbum, int id, Musica musica)
        {
            var musicaObtida = Obter(idAlbum, id);
            musicaObtida.Atualizar(musica);
        }

        public void DeletarMusica(int idAlbum, int id)
        {
            var album = Repositorio.albuns.Where(x => x.Id == idAlbum).FirstOrDefault();
            var musica = Obter(idAlbum, id);
            album?.Musicas.Remove(musica);
        }

        public List<Musica> ListarMusicas(int idAlbum)
        {
            return Repositorio.albuns.Where(x => x.Id == idAlbum).FirstOrDefault()?.Musicas;
        }

        public Musica Obter(int idAlbum, int id)
        {
            return Repositorio.albuns.Where(x => x.Id == idAlbum).FirstOrDefault()?.Musicas.Where(x => x.Id == id).FirstOrDefault();
        }

        public void SalvarMusica(int idAlbum, Musica musica)
        {
            var album = Repositorio.albuns.Where(x => x.Id == idAlbum).FirstOrDefault();
            musica.Id = Repositorio.idMusica;
            Repositorio.idMusica++;
            album.Musicas.Add(musica);
        }
    }
}