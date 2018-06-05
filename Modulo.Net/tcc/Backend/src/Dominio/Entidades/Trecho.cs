using System;
using Geolocation;

namespace Dominio.Entidades
{
    public class Trecho
    {
        public Trecho() { }

        public Trecho(double latitudeOrigem, double longitudeOrigem, double latitudeDestino, double longitudeDestino)
        {
            this.LatitudeOrigem = latitudeOrigem;
            this.LongitudeOrigem = longitudeOrigem;
            this.LatitudeDestino = latitudeDestino;
            this.LongitudeDestino = longitudeDestino;

            this.CalcularDistancia();
        }
        public int Id { get; set; }

        public double LatitudeOrigem { get; private set; }

        public double LongitudeOrigem { get; private set; }

        public double LatitudeDestino { get; private set; }

        public double LongitudeDestino { get; private set; }

        public double DistanciaTotal { get; private set; }

        public void CalcularDistancia()
        {
            var origem = new Coordinate()
            {
                Latitude = LatitudeOrigem,
                Longitude = LongitudeOrigem
            };
            var destino = new Coordinate()
            {
                Latitude = LatitudeDestino,
                Longitude = LongitudeDestino
            };
            this.DistanciaTotal = GeoCalculator.GetDistance(origem,destino,1);
        }
    }
}
