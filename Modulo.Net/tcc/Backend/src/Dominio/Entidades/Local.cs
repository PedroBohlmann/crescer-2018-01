namespace Dominio.Entidades
{
    public class Local
    {
        public Local() { }

        public Local(string cidade, string aeroporto, double latitude, double longitude)
        {
            this.Cidade = cidade;
            this.Aeroporto = aeroporto;
            this.Latitude = latitude;
            this.Longitude = longitude;
        }

        public int Id { get; set; }

        public string Cidade { get; private set; }

        public string Aeroporto { get; private set; }

        public double Latitude { get; private set; }

        public double Longitude { get; private set; }

        public void AtualizarLocal(Local novo)
        {
            this.Cidade = novo.Cidade;
            this.Aeroporto = novo.Aeroporto;
            this.Latitude = novo.Latitude;
            this.Longitude = novo.Longitude;
        }
    }
}