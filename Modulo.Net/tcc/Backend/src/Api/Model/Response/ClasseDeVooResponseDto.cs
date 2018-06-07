namespace Api.Model.Response
{
    public class ClasseDeVooResponseDto
    {
        public ClasseDeVooResponseDto(int id,string descricao, double valorFixo, double valorMilha)
        {
            this.Id=id;
            this.Descricao = descricao;
            this.ValorFixo = valorFixo;
            this.ValorMilha = valorMilha;
        }

        public int Id { get; set; }

        public string Descricao { get; set; }

        public double ValorFixo { get; set; }

        public double ValorMilha { get; set; }
    }
}