namespace Crescer.Spotify.Dominio.Entidades
{
    public class Avaliacao
    {
        public Avaliacao() { }



        public Avaliacao(int idMusica, int idUsuario, int nota)
        {
            this.IdMusica = idMusica;
            this.IdUsuario = idUsuario;
            this.Nota = nota;

        }
        public int Id { get; set; }
        public int IdMusica { get; private set; }

        public int IdUsuario { get; private set; }

        public int Nota { get; private set; }

    }
}