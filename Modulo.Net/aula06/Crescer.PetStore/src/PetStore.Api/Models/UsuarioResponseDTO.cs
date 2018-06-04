using PetStore.Dominio;
using PetStore.Dominio.Entidades;

namespace PetStore.Api.Models
{
    public class UsuarioResponseDTO
    {
        public UsuarioResponseDTO(Usuario usuario)
        {
            this.Id = usuario.Id;
            this.Login = usuario.Login;
            this.PrimeiroNome = usuario.PrimeiroNome;
            this.UltimoNome = usuario.UltimoNome;
            this.Email = usuario.Email;
            this.Telefone = usuario.Telefone;
            this.Status = usuario.Status;
        }

        public int Id { get; set; }

        public string Login { get; set; }

        public string PrimeiroNome { get; set; }

        public string UltimoNome { get; set; }

        public string Email { get; set; }

        public string Telefone { get; set; }

        public StatusUsuario Status { get; set; }
    }
}