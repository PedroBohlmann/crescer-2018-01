using System.Collections.Generic;
using Dominio.Entidades;

namespace Dominio.Servicos
{
    public class LocalService
    {
        public List<string> Validar(Local local)
        {
            List<string> mensagens = new List<string>();

            if (string.IsNullOrEmpty(local.Aeroporto))
            {
                mensagens.Add("Campo aeroporto é obrigatorio");
            }
            if (string.IsNullOrEmpty(local.Cidade))
            {
                mensagens.Add("Campo cidade é obrigatorio");
            }
            if (local.Latitude > 90 || local.Latitude < -90)
            {
                mensagens.Add("Latitude varia de -90 até 90");
            }
            if (local.Longitude > 180 || local.Longitude < -180)
            {
                mensagens.Add("Longitude varia de -180 até 180");
            }

            return mensagens;
        }
    }
}