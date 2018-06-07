using System;
using System.Collections.Generic;
using Dominio.Entidades;

namespace Dominio.Servicos
{
    public class UsuarioService
    {
        public List<string> Validar(Usuario usuario)
        {
            List<string> mensagens = new List<string>();

            if (usuario.Cpf?.Length > 11)
            {
                mensagens.Add("Cpf é um campo que possui somente 11 digitos");
            }
            if (string.IsNullOrEmpty(usuario.PrimeiroNome))
            {
                mensagens.Add("Primeiro nome é obrigatorio");
            }
            if (string.IsNullOrEmpty(usuario.UltimoNome))
            {
                mensagens.Add("Ultimo nome é obrigatorio");
            }
            if (string.IsNullOrEmpty(usuario.Senha))
            {
                mensagens.Add("Senha é obrigatorio");
            }
            if (usuario.DataNascimento==default(DateTime))
            {
                mensagens.Add("Data nascimento é obrigatorio");
            }

            return mensagens;
        }
    }
}