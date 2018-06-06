namespace Dominio.Entidades
{
    public class ClasseDeVoo
    {
        public ClasseDeVoo() { }

        public ClasseDeVoo(string descricao, double valorFixo, double valorMilha)
        {
            this.Descricao = descricao;
            this.ValorFixo = valorFixo;
            this.ValorMilha = valorMilha;
        }

        public int Id{get;set;}

        public string Descricao { get; private set; }

        public double ValorFixo { get; private set; }

        public double ValorMilha { get; private set; }
    }
}