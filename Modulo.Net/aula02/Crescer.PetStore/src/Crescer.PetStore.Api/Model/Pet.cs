using System.Collections.Generic;

namespace Crescer.PetStore.Api.Model
{
    public class Pet
    {
        public int Id{get;set;}

        public string Nome{get;set;}

        public List<string> Tags { get; set;}

        public Categoria Categoria{get;set;}
    }
}