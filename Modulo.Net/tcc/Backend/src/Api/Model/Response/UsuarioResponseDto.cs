using System;

namespace Api.Model.Response
{
    public class UsuarioResponseDto
    {
        public UsuarioResponseDto(int id, string primeiroNome, string ultimoNome, string cpf, DateTime dataNascimento, string email)
        {
            this.Id = id;
            this.PrimeiroNome = primeiroNome;
            this.UltimoNome = ultimoNome;
            this.Cpf = cpf;
            this.DataNascimento = dataNascimento;
            this.Email = email;
        }
        
        public int Id { get; set; }

        public string PrimeiroNome { get; set; }

        public string UltimoNome { get; set; }

        public string Cpf { get; set; }

        public DateTime DataNascimento { get; set; }

        public string Email { get; set; }
    }
}