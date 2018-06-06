using System.Collections.Generic;
using Dominio.Contratos;
using Dominio.Entidades;

namespace Infra.Repository
{
    public class ReservaRepository : IReservaRepository
    {

        private VooContext contexto;

        public ReservaRepository(VooContext contexto)
        {
            this.contexto = contexto;
        }

        public void AtualizarReserva(int id, Reserva reserva)
        {
            throw new System.NotImplementedException();
        }

        public void DeletarReserva(int id)
        {
            throw new System.NotImplementedException();
        }

        public List<Reserva> ListarReservas()
        {
            throw new System.NotImplementedException();
        }

        public Reserva ObterReserva(int id)
        {
            throw new System.NotImplementedException();
        }

        public void SalvarReserva(Reserva reserva)
        {
            contexto.Reservas.Add(reserva);
        }
    }
}