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
using Microsoft.AspNetCore.Authorization;
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

        private IUsuarioRepository usuarioRepository;

        public ReservaController(VooContext contexto, IReservaRepository reservaRepository,
                                    ITrechoRepository trechoRepository, IClasseDeVooRepository classeDeVooRepository,
                                    IOpcionalRepository opcionalRepository, ReservaService reservaService,
                                    IUsuarioRepository usuarioRepository)
        {
            this.contexto = contexto;
            this.reservaRepository = reservaRepository;
            this.trechoRepository = trechoRepository;
            this.classeDeVooRepository = classeDeVooRepository;
            this.opcionalRepository = opcionalRepository;
            this.reservaService = reservaService;
            this.usuarioRepository=usuarioRepository;
        }

        [Authorize,HttpPost]
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

        [Authorize,HttpGet("{id}")]
        public IActionResult Get(int id)
        {
            var reserva = reservaRepository.ObterReserva(id);

            if (reserva == null)
            {
                return NotFound("Não existe reserva com esse id");
            }

            return Ok(MapearReservaParaResponse(reserva));
        }

        [Authorize,HttpGet("/listaReserva")]
        public IActionResult GetLista(int idUsuario)
        {
            var lista = reservaRepository.ListarReservas(idUsuario);

            var listaResponse = new List<ReservaResponseDto>();

            foreach (Reserva reserva in lista)
            {
                listaResponse.Add(MapearReservaParaResponse(reserva));
            }

            return Ok(listaResponse);
        }

        [Authorize,HttpDelete("id")]
        public IActionResult Delete(int id)
        {
            reservaRepository.DeletarReserva(id);

            contexto.SaveChanges();

            return Ok("Removido com sucesso");
        }

        [Authorize(Roles="Admin"),HttpPut("{id}")]
        public IActionResult Put(int id,[FromBody]ReservaRequestDto reservaDto)
        {
            var reserva = MapearReservaDtoParaReserva(reservaDto);

            var erros = reservaService.Validar(reserva);
            if(erros.Count>0)
            {
                return BadRequest(erros);
            }

            reservaRepository.AtualizarReserva(id,reserva);

            contexto.SaveChanges();

            return Ok("Dados atualizados");
        }

        private Reserva MapearReservaDtoParaReserva(ReservaRequestDto reserva)
        {
            var trecho = trechoRepository.ObterTrecho(reserva.IdTrecho);
            var classeDeVoo = classeDeVooRepository.ObterClasseDeVoo(reserva.IdClasseDeVoo);

            var usuario = usuarioRepository.ObterUsuarioPorId(reserva.IdUsuario);

            var reservaAtual = new Reserva(classeDeVoo, trecho,usuario);

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
            var response = new ReservaResponseDto(reserva.Id, reserva.ClasseDeVoo, reserva.Trecho, reserva.ValorTotal,reserva.Usuario.Id);

            foreach (OpcionalReserva opcionalReserva in reserva.Opcionais)
            {
                response.AdicionarOpcional(opcionalReserva.Opcional);

            }

            return response;
        }
    }
}
