using System.Collections.Generic;

namespace SpotifyCrescer.Dominio.Model
{
    public class Album
    {
        public int Id{get;set;}

        public string Nome{get;set;}

        public List<Musica> Musicas{get;set;}
    }
}