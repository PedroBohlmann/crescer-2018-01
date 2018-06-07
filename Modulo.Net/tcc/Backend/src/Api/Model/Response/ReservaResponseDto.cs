using System.Collections.Generic;
using Dominio.Entidades;

namespace Api.Model.Response
{
    public class ReservaResponseDto
    {
        public ReservaResponseDto(int id, ClasseDeVoo classeDeVoo, Trecho trecho, List<OpcionalReserva> opcionais, double valorTotal)
        {
            this.ClasseDeVoo = classeDeVoo;
            this.Trecho = trecho;
            this.Opcionais = opcionais;
            this.ValorTotal = valorTotal;
            this.Id=id;

        }
        public List<OpcionalReserva> Opcionais { get; set; }

        public ClasseDeVoo ClasseDeVoo { get; set; }

        public Trecho Trecho { get; set; }

        public double ValorTotal { get; set; }

        public int Id { get; set; }

    }
}