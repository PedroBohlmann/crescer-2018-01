namespace Malaysia.Airlines
{
    public class AviaoTurboElice : Aviao
    {
        public AviaoTurboElice(string nome, int quantidadeMotores, double custoFuncionamentoCadaMotor) : base(nome, quantidadeMotores, custoFuncionamentoCadaMotor)
        {
            this.PercentualCalculoMotor = 1.2;
        }

        public double PercentualCalculoMotor { get; set; }

        public override double CalculaValorBase(){
            return custoFuncionamentoCadaMotor*(quantidadeMotores*PercentualCalculoMotor);
        }
    }
}