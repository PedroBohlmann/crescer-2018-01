using System;
using Geolocation;

namespace Dominio.Entidades
{
    public class Trecho
    {
        public Trecho() { }


        public Trecho(Local origem, Local destino)
        {
            this.Origem = origem;
            this.Destino = destino;

            CalcularDistancia();
        }
        public int Id { get; set; }

        public Local Origem { get; private set; }

        public Local Destino { get; private set; }

        public double DistanciaTotal { get; private set; }

        public void CalcularDistancia()
        {
            if (Origem == null || Destino == null) return;

            var origem = new Coordinate()
            {
                Latitude = Origem.Latitude,
                Longitude = Origem.Longitude
            };
            var destino = new Coordinate()
            {
                Latitude = Destino.Latitude,
                Longitude = Destino.Longitude
            };
            this.DistanciaTotal = GeoCalculator.GetDistance(origem, destino, 1);
        }
    }
}
