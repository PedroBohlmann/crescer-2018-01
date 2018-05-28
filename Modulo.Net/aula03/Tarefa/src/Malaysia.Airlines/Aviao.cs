namespace Malaysia.Airlines
{
    public abstract class Aviao
    {
        public Aviao(string nome, int quantidadeMotores, double custoFuncionamentoCadaMotor)
        {
            this.nome = nome;
            this.quantidadeMotores = quantidadeMotores;
            this.custoFuncionamentoCadaMotor=custoFuncionamentoCadaMotor;
        }

        public double custoFuncionamentoCadaMotor { get; set; }
        public string nome { get; set; }
        public int quantidadeMotores { get; set; }

        public abstract double CalculaValorBase();
    }
}