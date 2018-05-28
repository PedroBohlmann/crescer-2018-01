namespace Malaysia.Airlines
{
    public class Voo
    {
        public Voo(Aviao aviao, Rota rota)
        {
            this.viagem = rota;
            this.aviao = aviao;
        }

        public Rota viagem { get; set; }
        public Aviao aviao { get; set; }

        public double ValorTotalVoo(){
            return (viagem.DistanciaEmMilhas()*aviao.CalculaValorBase());
        }
    }
}