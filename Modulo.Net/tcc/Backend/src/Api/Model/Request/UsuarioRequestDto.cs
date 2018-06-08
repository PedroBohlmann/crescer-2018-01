using System;

namespace Api.Model.Request
{
    public class UsuarioRequestDto
    {
        public string PrimeiroNome { get; set; }

        public string UltimoNome { get; set; }

        public string Cpf { get; set; }

        public DateTime DataNascimento { get; set; }

        public string Email { get; set; }

        public string Senha { get; set; }
    }
}