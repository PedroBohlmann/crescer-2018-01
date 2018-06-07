namespace Api.Model.Response
{
    public class OpcionalResponseDto
    {
        public OpcionalResponseDto(int id,string nome, string descricao, double valorPorcentagem)
        {
            this.Id=id;
            this.Nome = nome;
            this.Descricao = descricao;
            this.ValorPorcentagem = valorPorcentagem;
        }

        public int Id { get; set; }

        public string Nome { get; set; }

        public string Descricao { get; set; }

        public double ValorPorcentagem { get; set; }
    }
}