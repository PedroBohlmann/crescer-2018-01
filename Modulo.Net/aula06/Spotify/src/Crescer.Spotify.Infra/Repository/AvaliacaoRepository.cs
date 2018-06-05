using System.Collections.Generic;
using System.Linq;
using Crescer.Spotify.Dominio.Contratos;
using Crescer.Spotify.Dominio.Entidades;
using Dapper;
using Microsoft.EntityFrameworkCore;

namespace Crescer.Spotify.Infra.Repository
{
    public class AvaliacaoRepository : IAvaliacaoRepository
    {
        private SpotifyContext contexto;

        private IAlbumRepository albumRepository;
        public AvaliacaoRepository(SpotifyContext contexto,IAlbumRepository albumRepository)
        {
            this.contexto = contexto;
            this.albumRepository=albumRepository;
        }

        public void AtualizarAvaliacao(Avaliacao avaliacao)
        {
            var avaliacaoSalva = contexto.Avaliacoes.FirstOrDefault(p=>(p.Musica.Id==avaliacao.Musica.Id && p.Usuario.Id==avaliacao.Usuario.Id));
            avaliacaoSalva.AtualizarAvaliacao(avaliacao);
        }

        public double? AvaliacaoAlbum(int idAlbum)
        {
            var album = albumRepository.Obter(idAlbum);

            if(album==null) return null;

            double somatorio = 0;
            int numeroDeMedias=0;
            foreach(Musica musica in album.Musicas)
            {
                double? media=MediaAvaliacoes(musica.Id);
                if(media!=null){
                    somatorio+=(double)media;
                }
                numeroDeMedias++;
            }
            return somatorio/numeroDeMedias;
        }

        public double? MediaAvaliacoes(int idMusica)
        {
            var media = contexto.Avaliacoes.Where(p=>p.Musica.Id==idMusica).Average(p=>p.Nota);
            return media;
        }

        public void SalvarAvaliacao(Avaliacao avaliacao)
        {
            if (VerificaSeExisteAlgumaAvaliacao(avaliacao))
            {
                AtualizarAvaliacao(avaliacao);
            }
            else
            {
                contexto.Avaliacoes.Add(avaliacao);
            }

        }

        public bool VerificaSeExisteAlgumaAvaliacao(Avaliacao avaliacao)
        {
            return contexto.Avaliacoes.AsNoTracking().FirstOrDefault(p=>(p.Musica.Id==avaliacao.Musica.Id && p.Usuario.Id==avaliacao.Usuario.Id))!=null;
        }
    }
}