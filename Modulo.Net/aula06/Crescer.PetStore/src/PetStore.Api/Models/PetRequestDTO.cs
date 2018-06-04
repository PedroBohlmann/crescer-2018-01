using System.Collections.Generic;
using PetStore.Dominio.Entidades;

namespace PetStore.Api.Models
{
    public class PetRequestDTO
    {
        public string Nome { get; set; }

        public int IdCategoria { get; set; }

        public List<string> Tags { get; set; }

        public StatusPet Status { get; set; }
    }
}