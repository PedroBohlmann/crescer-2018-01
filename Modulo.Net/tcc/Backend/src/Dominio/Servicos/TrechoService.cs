using System.Collections.Generic;
using Dominio.Entidades;

namespace Dominio.Servicos
{
    public class TrechoService
    {
        public List<string> Validar(Trecho trecho)
        {
            List<string> mensagens = new List<string>();

            if (trecho.LatitudeDestino <= 0)
            {
                mensagens.Add("LatitudeDestino é um campo obrigatorio");
            }
            if (trecho.LongitudeDestino <= 0)
            {
                mensagens.Add("LongitudeDestino é um campo obrigatorio");
            }
            if (trecho.LatitudeOrigem <= 0)
            {
                mensagens.Add("LatitudeOrigem é um campo obrigatorio");
            }
            if (trecho.LongitudeOrigem <= 0)
            {
                mensagens.Add("LongitudeOrigem é um campo obrigatorio");
            }

            return mensagens;
        }
    }
}