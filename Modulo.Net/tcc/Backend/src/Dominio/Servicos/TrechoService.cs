using System.Collections.Generic;
using Dominio.Entidades;

namespace Dominio.Servicos
{
    public class TrechoService
    {
        public List<string> Validar(Trecho trecho)
        {
            List<string> mensagens = new List<string>();

            if (trecho.Origem == null)
            {
                mensagens.Add("Campo Origem é obrigatorio");
            }
            if (trecho.Destino == null)
            {
                mensagens.Add("Campo Destino é obrigatorio");
            }
            if(trecho.Origem==trecho.Destino){
                mensagens.Add("Origem e destino precisam ser diferentes");
            }

            return mensagens;
        }
    }
}