using System.Collections.Generic;
using Dominio.Entidades;

namespace Dominio.Contratos
{
    public interface IReservaRepository
    {
        void SalvarReserva(Reserva reserva);
        void AtualizarReserva(int id, Reserva reserva);

        void DeletarReserva(int id);

        Reserva ObterReserva(int id);

        List<Reserva> ListarReservas(int id);

    }
}