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
    public class TrechoController : Controller
    {
        private VooContext contexto;

        private ITrechoRepository trechoRepositorio;

        private TrechoService trechoService;

        private ILocalRepository localRepository;

        public TrechoController(VooContext contexto, ITrechoRepository trechoRepositorio, TrechoService trechoService,ILocalRepository localRepository)
        {
            this.contexto = contexto;
            this.trechoRepositorio = trechoRepositorio;
            this.trechoService = trechoService;
            this.localRepository = localRepository;
        }

        [HttpPost]
        public IActionResult Post([FromBody]TrechoRequestDto trechoDto)
        {
            var trecho = MapearTrechoDtoParaTrecho(trechoDto);

            var erros = trechoService.Validar(trecho);

            if(erros.Count>0)
            {
                return BadRequest(erros);
            }

            trechoRepositorio.SalvarTrecho(trecho);

            contexto.SaveChanges();

            return Ok(trecho);
        }

        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {
            var trecho = trechoRepositorio.ObterTrecho(id);

            if(trecho==null)
            {
                return NotFound("Não existe trecho com esse id");
            }

            return Ok(MapearTrechoParaTrechoResponse(trecho));// fazer mapeamento para para o response
        }

        [HttpGet("/lista")]
        public IActionResult Get()
        {
            var lista = trechoRepositorio.ListarTrechos();

            return Ok(lista);
        }

        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            trechoRepositorio.DeletarTrecho(id);

            contexto.SaveChanges();

            return Ok("Trecho removido");
        }

        [HttpPut("{id}")]
        public IActionResult Put(int id,[FromBody]TrechoRequestDto trechoDto)
        {
            var trecho = MapearTrechoDtoParaTrecho(trechoDto);

            trechoRepositorio.AtualizarTrecho(id,trecho);

            contexto.SaveChanges();

            return Ok("Trecho alterado");
        }

        private Trecho MapearTrechoDtoParaTrecho(TrechoRequestDto trechoDto)
        {
            var origem=localRepository.ObterLocal(trechoDto.IdOrigem);
            var destino = localRepository.ObterLocal(trechoDto.IdDestino);

            var trecho = new Trecho(origem,destino);

            return trecho;
        }

        private TrechoResponseDto MapearTrechoParaTrechoResponse(Trecho trecho)
        {
            var response = new TrechoResponseDto(trecho.Id,trecho.Origem,trecho.Destino,trecho.DistanciaTotal);

            return response;
        }
    }
}