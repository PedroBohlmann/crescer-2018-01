using System.Collections.Generic;

namespace Crescer.PetStore.Api.Model
{
    public class PetDatabase
    {
        public int Id{get;set;}

        public List<Pet> Lista{get;set;}
    }
}