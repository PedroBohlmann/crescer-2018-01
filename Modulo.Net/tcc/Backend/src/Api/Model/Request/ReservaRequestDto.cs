using System.Collections.Generic;

namespace Api.Model.Request
{
    public class ReservaRequestDto
    {
        public int IdClasseDeVoo { get; set; }

        public int IdTrecho { get; set; }

        public List<int> IdOpcionais { get; set; }
    }
}