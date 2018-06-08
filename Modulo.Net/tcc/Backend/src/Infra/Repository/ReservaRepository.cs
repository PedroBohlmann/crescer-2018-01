using System.Collections.Generic;
using System.Linq;
using Dominio.Contratos;
using Dominio.Entidades;
using Microsoft.EntityFrameworkCore;

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
            var reservaSalva = contexto.Reservas.FirstOrDefault(p => p.Id == id);
            reservaSalva.AtualizarReserva(reserva);
        }

        public void DeletarReserva(int id)
        {
            var reserva = contexto.Reservas.FirstOrDefault(p => p.Id == id);
            contexto.Reservas.Remove(reserva);
        }

        public List<Reserva> ListarReservas()
        {
            return contexto.Reservas.Include(p => p.ClasseDeVoo)
            .Include(p => p.Trecho.Destino)
            .Include(p => p.Trecho.Origem)
            .Include(p => p.Opcionais)
            .ThenInclude(p => p.Opcional)
            .Include(p=>p.Usuario)            
            .ToList();
        }

        public Reserva ObterReserva(int id)
        {
            return contexto.Reservas
            .Include(p => p.ClasseDeVoo)
            .Include(p => p.Trecho.Destino)
            .Include(p => p.Trecho.Origem)
            .Include(p => p.Opcionais)
            .ThenInclude(p => p.Opcional)
            .Include(p=>p.Usuario)
            .FirstOrDefault(p => p.Id == id);
        }

        public void SalvarReserva(Reserva reserva)
        {
            contexto.Reservas.Add(reserva);
        }
    }
}