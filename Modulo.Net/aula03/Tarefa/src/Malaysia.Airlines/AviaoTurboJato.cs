namespace Malaysia.Airlines
{
    public class AviaoTurboJato : Aviao
    {
        public AviaoTurboJato(string nome, int quantidadeMotores, double custoFuncionamentoCadaMotor):base(nome,quantidadeMotores,custoFuncionamentoCadaMotor){
            this.PercentualCalculoMotor=1.5;
        }

        public double PercentualCalculoMotor{get;set;}

        public override double CalculaValorBase(){
            return custoFuncionamentoCadaMotor*(quantidadeMotores*PercentualCalculoMotor);
        }
    }
}