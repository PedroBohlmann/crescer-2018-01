using PetStore.Dominio.Entidades;

namespace PetStore.Api.Models
{
    public class UsuarioRequestDTO
    {
        public string Login { get; set; }

        public string Senha { get; set; }

        public string PrimeiroNome { get; set; }

        public string UltimoNome { get; set; }

        public int Idade { get; set; }

        public string Email { get; set; }

        public string Telefone { get; set; }

        public StatusUsuario StatusUsuario { get; set; }
    }
}