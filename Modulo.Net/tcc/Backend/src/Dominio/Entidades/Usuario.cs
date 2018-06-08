using System;

namespace Dominio.Entidades
{
    public class Usuario
    {
        public Usuario(){ }

        public Usuario(string primeiroNome, string ultimoNome, string cpf, DateTime dataNascimento, string email, string senha)
        {
            this.PrimeiroNome = primeiroNome;
            this.UltimoNome = ultimoNome;
            this.Cpf = cpf;
            this.DataNascimento = dataNascimento;
            this.Email = email;
            this.Senha = senha;
            this.Admin=false;
        }
        public int Id { get; set; }

        public string PrimeiroNome { get; private set; }

        public string UltimoNome { get; private set; }

        public string Cpf { get; private set; }

        public DateTime DataNascimento { get; private set; }

        public string Email { get; private set; }

        public string Senha { get; set; }

        public bool Admin { get; set; }

        public void AtualizarSenha(string senha)
        {
            this.Senha = senha;
        }
    }
}