using System.Collections.Generic;
using System.Linq;

namespace SpotifyCrescer.Dominio.Model
{
    public class Album
    {
        public Album(string nome)
        {
            this.Nome = nome;
            Musicas=new List<Musica>();
        }
        public int Id { get; set; }

        public string Nome { get; private set; }

        public List<Musica> Musicas { get; private set; }

        public void AdicionarMusica(Musica musica)
        {
            Musicas.Add(musica);
        }
    }
}