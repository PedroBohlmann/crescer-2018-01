namespace Crescer.Spotify.Dominio.Entidades
{
    public class Usuario
    {
        public Usuario(){ }

        public Usuario(string nome){
            this.Nome=nome;
        }

        public string Nome{get; private set;}

        public int Id{get;set;}

        public void AtualizarUsuario(Usuario usuario){
            this.Nome=usuario.Nome;
        }
    }
}