namespace Api.Model.Response
{
    public class LocalResponseDto
    {
        public LocalResponseDto(int id, string cidade, string aeroporto, double latitude, double longitude)
        {
            this.Id = id;
            this.Cidade = cidade;
            this.Aeroporto = aeroporto;
            this.Latitude = latitude;
            this.Longitude = longitude;

        }
        public int Id { get; set; }
        public string Cidade { get; set; }

        public string Aeroporto { get; set; }

        public double Latitude { get; set; }

        public double Longitude { get; set; }
    }
}