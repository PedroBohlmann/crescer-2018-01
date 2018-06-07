using System.Collections.Generic;
using Dominio.Entidades;

namespace Api.Model.Response
{
    public class ReservaResponseDto
    {
        public ReservaResponseDto(int id, ClasseDeVoo classeDeVoo, Trecho trecho, double valorTotal,int idUsuario)
        {
            this.ClasseDeVoo = classeDeVoo;
            this.Trecho = trecho;
            this.ValorTotal = valorTotal;
            this.Id=id;
            this.Opcionais=new List<Opcional>();
            this.IdUsuario = idUsuario;
        }
        public List<Opcional> Opcionais { get; set; }

        public ClasseDeVoo ClasseDeVoo { get; set; }

        public Trecho Trecho { get; set; }

        public double ValorTotal { get; set; }

        public int Id { get; set; }

        public int IdUsuario{get;set;}

        public void AdicionarOpcional(Opcional opcional)
        {
            Opcionais.Add(opcional);
        }
    }
}