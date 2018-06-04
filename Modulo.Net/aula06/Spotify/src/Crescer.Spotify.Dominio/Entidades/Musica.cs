using System;

namespace Crescer.Spotify.Dominio.Entidades
{
    public class Musica
    {
        public Musica() { }
        public Musica(string nome, double duracao)
        {
            this.Nome = nome;
            this.Duracao = duracao;
        }
        public int Id { get; set; }
        public string Nome { get; private set; }
        public double Duracao { get; private set; }        

        public void Atualizar(Musica musica)
        {
            Nome = musica.Nome;
            Duracao = musica.Duracao;
        }
    }
}