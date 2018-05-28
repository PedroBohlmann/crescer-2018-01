using Geolocation;
namespace Malaysia.Airlines
{
    public class Rota
    {
        public Rota(Ponto A, Ponto B)
        {
            this.A = A;
            this.B = B;
        }

        public Ponto A { get; set; }
        public Ponto B { get; set; }

        public double DistanciaEmMilhas()
        {
            return GeoCalculator.GetDistance(A.Local, B.Local, 1);
        }
    }
}