namespace PetStore.Dominio.Entidades
{
    public class Usuario
    {
        private Usuario() { }

        public Usuario(string login, string senha, string primeiroNome, string ultimoNome, int idade, string email, string telefone, StatusUsuario status)
        {
            this.Login = login;
            this.Senha = senha;
            this.PrimeiroNome = primeiroNome;
            this.UltimoNome = ultimoNome;
            this.Idade = idade;
            this.Email = email;
            this.Telefone = telefone;
            this.Status = status;
        }

        public int Id { get; private set; }

        public string Login { get; private set; }

        public string Senha { get; private set; }

        public string PrimeiroNome { get; private set; }

        public string UltimoNome { get; private set; }

        public int Idade { get; private set; }

        public string Email { get; private set; }

        public string Telefone { get; private set; }

        public StatusUsuario Status { get; private set; }
    }
}