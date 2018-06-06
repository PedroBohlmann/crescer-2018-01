using System.Collections.Generic;

namespace Dominio.Entidades
{
    public class Reserva
    {
        public Reserva() { }

        public Reserva(ClassesDeVoo classeDeVoo, Trecho trecho)
        {
            this.ClasseDeVoo = classeDeVoo;
            this.Trecho = trecho;
            this.Opcionais = new List<Opcional>();

            CalcularValorTotal();
        }

        public List<Opcional> Opcionais { get; private set; }

        public ClassesDeVoo ClasseDeVoo { get; private set; }

        public Trecho Trecho { get; private set; }

        public double ValorTotal { get; private set; }

        public int Id { get; set; }

        public void CalcularValorTotal()
        {
            if(ClasseDeVoo==null||Trecho==null) return;

            var valorBase = ClasseDeVoo.ValorFixo + (Trecho.DistanciaTotal * ClasseDeVoo.ValorMilha);
            var valorOpcional = 0.0;

            foreach (Opcional opcional in Opcionais)
            {
                valorOpcional += opcional.ValorPorcentagem * valorBase;
            }

            ValorTotal = valorBase + valorOpcional;
        }

        public void AdicionarOpcional(Opcional opcional)
        {
            Opcionais.Add(opcional);
            CalcularValorTotal();
        }

    }
}