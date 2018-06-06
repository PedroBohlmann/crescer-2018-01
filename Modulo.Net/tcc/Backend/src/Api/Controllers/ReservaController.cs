using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Api.Model.Request;
using Dominio.Contratos;
using Dominio.Entidades;
using Infra;
using Microsoft.AspNetCore.Mvc;

namespace Api.Controllers
{
    [Route("api/[controller]")]
    public class ReservaController : Controller
    {
        private VooContext contexto;

        private IReservaRepository reservaRepository;

        public ReservaController(VooContext contexto, IReservaRepository reservaRepository)
        {
            this.contexto = contexto;
            this.reservaRepository = reservaRepository;
        }

        [HttpPost]
        public IActionResult Post([FromBody]ReservaDto reservaDto)
        {
            var reserva = MapearReservaDtoParaReserva(reservaDto);

            reservaRepository.SalvarReserva(reserva);

            contexto.SaveChanges();

            return Ok(reserva.ValorTotal);
        }

        private Reserva MapearReservaDtoParaReserva(ReservaDto reserva)
        {
            var trecho = contexto.Trechos.FirstOrDefault(p => p.Id == reserva.IdTrecho);
            var classeDeVoo = contexto.ClassesDeVoo.FirstOrDefault(p => p.Id == reserva.IdClasseDeVoo);

            var reservaAtual = new Reserva(classeDeVoo, trecho);

            foreach (int x in reserva.IdOpcionais)
            {
                var opcional = contexto.Opcional.FirstOrDefault(p => p.Id == x);
                if (opcional != null)
                {
                    reservaAtual.AdicionarOpcional(opcional);
                }
            }

            return reservaAtual;
        }
    }
}
