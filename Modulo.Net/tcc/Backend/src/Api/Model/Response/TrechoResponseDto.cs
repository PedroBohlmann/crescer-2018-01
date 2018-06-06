using Dominio.Entidades;

namespace Api.Model.Response
{
    public class TrechoResponseDto
    {
        public TrechoResponseDto(int id, Local origem, Local destino, double distanciaTotal)
        {
            this.Id = id;
            this.Origem = origem;
            this.Destino = destino;
            this.DistanciaTotal = distanciaTotal;

        }
        public int Id { get; set; }

        public Local Origem { get; set; }

        public Local Destino { get; set; }

        public double DistanciaTotal { get; set; }
    }
}