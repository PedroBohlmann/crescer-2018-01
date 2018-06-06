using System.Collections.Generic;

namespace Dominio.Entidades
{
    public class Reserva
    {
        public Reserva() { }

        public Reserva(ClasseDeVoo classeDeVoo, Trecho trecho)
        {
            this.ClasseDeVoo = classeDeVoo;
            this.Trecho = trecho;
            this.Opcionais = new List<OpcionalReserva>();

            CalcularValorTotal();
        }

        public List<OpcionalReserva> Opcionais { get; private set; }

        public ClasseDeVoo ClasseDeVoo { get; private set; }

        public Trecho Trecho { get; private set; }

        public double ValorTotal { get; private set; }

        public int Id { get; set; }

        public void CalcularValorTotal()
        {
            if(ClasseDeVoo==null||Trecho==null) return;

            var valorBase = ClasseDeVoo.ValorFixo + (Trecho.DistanciaTotal * ClasseDeVoo.ValorMilha);
            var valorOpcional = 0.0;

            foreach (OpcionalReserva opcional in Opcionais)
            {
                valorOpcional += opcional.Opcional.ValorPorcentagem * valorBase;
            }

            ValorTotal = valorBase + valorOpcional;
        }

        public void AdicionarOpcional(Opcional opcional)
        {
            var opcionalReserva = new OpcionalReserva(opcional,this);
            Opcionais.Add(opcionalReserva);
            CalcularValorTotal();
        }

    }
}