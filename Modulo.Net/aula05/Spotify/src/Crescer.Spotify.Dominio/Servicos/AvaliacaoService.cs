using System.Collections.Generic;
using Crescer.Spotify.Dominio.Entidades;

namespace Crescer.Spotify.Dominio.Servicos
{
    public class AvaliacaoService
    {
        public List<string> Validar(Avaliacao avaliacao)
        {
             List<string> mensagens = new List<string>();

             if(avaliacao.IdMusica<=0)
             {
                mensagens.Add($"{nameof(avaliacao.IdMusica)} é um campo obrigatorio");
             }
             if(avaliacao.IdUsuario<=0)
             {
                mensagens.Add($"{nameof(avaliacao.IdUsuario)} é um campo obrigatorio");
             }
             if(avaliacao.Nota<=0 || avaliacao.Nota>5)
             {
                mensagens.Add($"{nameof(avaliacao.Nota)} que precisa estar entre 0 e 5");
             }

             return mensagens;
        }
    }
}