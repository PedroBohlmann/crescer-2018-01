namespace Dominio.Entidades
{
    public class OpcionalReserva
    {
        public OpcionalReserva() { }

        public OpcionalReserva(Opcional opcional, Reserva reserva)
        {
            this.Opcional = opcional;
            this.Reserva = reserva;
        }

        public int Id{get;set;}

        public Opcional Opcional { get; private set; }

        public Reserva Reserva { get; private set; }
    }
}