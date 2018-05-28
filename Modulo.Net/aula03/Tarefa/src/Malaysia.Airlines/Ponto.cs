using System;
using Geolocation;

namespace Malaysia.Airlines
{
    public class Ponto
    {
        public Ponto(double novaLatitude, double novaLongitude)
        {
            Local = new Coordinate()
            {
                Latitude = novaLatitude,
                Longitude = novaLongitude
            };
        }

        public Coordinate Local { get; set; }
    }
}
