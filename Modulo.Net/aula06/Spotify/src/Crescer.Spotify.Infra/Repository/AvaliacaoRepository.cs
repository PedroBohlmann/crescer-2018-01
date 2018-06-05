using System.Collections.Generic;
using System.Linq;
using Crescer.Spotify.Dominio.Contratos;
using Crescer.Spotify.Dominio.Entidades;
using Dapper;
using LojinhaDoCrescer.Infra;
using Microsoft.EntityFrameworkCore;

namespace Crescer.Spotify.Infra.Repository
{
    public class AvaliacaoRepository : IAvaliacaoRepository
    {
        private SpotifyContext contexto;
        public AvaliacaoRepository(SpotifyContext contexto)
        {
            this.contexto = contexto;
        }

        public void AtualizarAvaliacao(Avaliacao avaliacao)
        {
            var avaliacaoSalva = contexto.Avaliacoes.FirstOrDefault(p=>(p.Musica.Id==avaliacao.Musica.Id && p.Usuario.Id==avaliacao.Usuario.Id));
            avaliacaoSalva.AtualizarAvaliacao(avaliacao);
        }

        public double? AvaliacaoAlbum(int idAlbum)
        {
            return null;
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