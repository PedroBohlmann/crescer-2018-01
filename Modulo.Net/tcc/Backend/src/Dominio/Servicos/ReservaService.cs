using System.Collections.Generic;
using Dominio.Entidades;

namespace Dominio.Servicos
{
    public class ReservaService
    {
        public List<string> Validar(Reserva reserva)
        {
            List<string> mensagens = new List<string>();
            
            if(reserva.ClasseDeVoo==null){
                mensagens.Add("ClasseDeVoo é um campo obrigatorio");
            }
            if(reserva.Trecho==null){
                mensagens.Add("Trecho é um campo obrigatorio");
            }

            return mensagens;
        }
    }
}