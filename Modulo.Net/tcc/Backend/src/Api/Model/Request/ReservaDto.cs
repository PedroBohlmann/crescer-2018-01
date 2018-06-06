using System.Collections.Generic;

namespace Api.Model.Request
{
    public class ReservaDto
    {
        public int IdClasseDeVoo { get; set; }

        public int IdTrecho { get; set; }

        public List<int> IdOpcionais { get; set; }
    }
}