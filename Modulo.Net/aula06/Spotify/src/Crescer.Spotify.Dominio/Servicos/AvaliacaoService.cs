using System.Collections.Generic;
using Crescer.Spotify.Dominio.Entidades;

namespace Crescer.Spotify.Dominio.Servicos
{
    public class AvaliacaoService
    {
        public List<string> Validar(Avaliacao avaliacao)
        {
             List<string> mensagens = new List<string>();

             if(avaliacao.Musica.Id<=0)
             {
                mensagens.Add($"{nameof(avaliacao.Musica.Id)} é um campo obrigatorio");
             }
             if(avaliacao.Usuario.Id<=0)
             {
                mensagens.Add($"{nameof(avaliacao.Usuario.Id)} é um campo obrigatorio");
             }
             if(avaliacao.Nota<=0 || avaliacao.Nota>5)
             {
                mensagens.Add($"{nameof(avaliacao.Nota)} que precisa estar entre 0 e 5");
             }

             return mensagens;
        }
    }
}