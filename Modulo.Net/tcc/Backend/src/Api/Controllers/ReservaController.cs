using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Api.Model.Request;
using Api.Model.Response;
using Dominio.Contratos;
using Dominio.Entidades;
using Dominio.Servicos;
using Infra;
using Microsoft.AspNetCore.Mvc;

namespace Api.Controllers
{
    [Route("api/[controller]")]
    public class ReservaController : Controller
    {
        private VooContext contexto;

        private IReservaRepository reservaRepository;

        private ITrechoRepository trechoRepository;

        private IClasseDeVooRepository classeDeVooRepository;

        private IOpcionalRepository opcionalRepository;

        private ReservaService reservaService;

        public ReservaController(VooContext contexto, IReservaRepository reservaRepository,
                                    ITrechoRepository trechoRepository, IClasseDeVooRepository classeDeVooRepository,
                                    IOpcionalRepository opcionalRepository, ReservaService reservaService)
        {
            this.contexto = contexto;
            this.reservaRepository = reservaRepository;
            this.trechoRepository = trechoRepository;
            this.classeDeVooRepository = classeDeVooRepository;
            this.opcionalRepository = opcionalRepository;
            this.reservaService = reservaService;
        }

        [HttpPost]
        public IActionResult Post([FromBody]ReservaRequestDto reservaDto)
        {
            var reserva = MapearReservaDtoParaReserva(reservaDto);

            var erros = reservaService.Validar(reserva);

            if (erros.Count > 0)
            {
                return BadRequest(erros);
            }

            reservaRepository.SalvarReserva(reserva);

            contexto.SaveChanges();

            return Ok(MapearReservaParaResponse(reserva));
        }

        private Reserva MapearReservaDtoParaReserva(ReservaRequestDto reserva)
        {
            var trecho = trechoRepository.ObterTrecho(reserva.IdTrecho);
            var classeDeVoo = classeDeVooRepository.ObterClasseDeVoo(reserva.IdClasseDeVoo);

            var reservaAtual = new Reserva(classeDeVoo, trecho);

            foreach (int x in reserva.IdOpcionais)
            {
                var opcional = opcionalRepository.ObterOpcional(x);
                if (opcional != null)
                {
                    reservaAtual.AdicionarOpcional(opcional);
                }
            }

            return reservaAtual;
        }

        private ReservaResponseDto MapearReservaParaResponse(Reserva reserva)
        {
            return new ReservaResponseDto(reserva.Id,reserva.ClasseDeVoo,reserva.Trecho,reserva.Opcionais,reserva.ValorTotal);
        }
    }
}
