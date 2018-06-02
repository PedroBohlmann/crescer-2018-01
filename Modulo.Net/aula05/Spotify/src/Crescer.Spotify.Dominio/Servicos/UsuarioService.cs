using System.Collections.Generic;
using Crescer.Spotify.Dominio.Entidades;

namespace Crescer.Spotify.Dominio.Servicos
{
    public class UsuarioService
    {
        public List<string> Validar(Usuario usuario)
        {
            List<string> mensagens = new List<string>();
            
            if(string.IsNullOrEmpty(usuario.Nome)){
                mensagens.Add("É preciso informar o campo nome do usuario");
            }

            return mensagens;
        }
    }
}