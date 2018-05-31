using System;

namespace SpotifyCrescer.Dominio.Model
{
    public class Musica
    {
        public Musica(string nome, double duracao)
        {
            this.Nome = nome;
            this.Duracao = duracao;

        }
        public int Id { get; set;}

        public string Nome { get; private set; }

        public double Duracao { get; private set; }

    }
}
