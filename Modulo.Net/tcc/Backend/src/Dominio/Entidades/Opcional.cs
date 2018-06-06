namespace Dominio.Entidades
{
    public class Opcional
    {
        public Opcional() { }

        public Opcional(string nome, string descricao, double valorPorcentagem)
        {
            this.Nome = nome;
            this.Descricao = descricao;
            this.ValorPorcentagem = valorPorcentagem;
        }
        
        public int Id{get;set;}

        public string Nome { get; private set; }

        public string Descricao { get; private set; }

        public double ValorPorcentagem { get; private set; }
    }
}