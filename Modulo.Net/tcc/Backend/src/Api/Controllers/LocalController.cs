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
    public class LocalController : Controller
    {
        private VooContext contexto;

        private ILocalRepository localRepositorio;

        private LocalService localService;

        public LocalController(VooContext contexto, ILocalRepository localRepositorio, LocalService localService)
        {
            this.contexto = contexto;
            this.localRepositorio = localRepositorio;
            this.localService = localService;
        }

        [HttpPost]
        public IActionResult Post([FromBody]LocalResquestDto localDto)
        {
            var local = MapearLocalRequestDtoParaLocal(localDto);

            var erros = localService.Validar(local);

            if (erros.Count > 0)
            {
                return BadRequest(erros);
            }

            localRepositorio.SalvarLocal(local);

            var retorno = MapearLocalParaLocalResponse(local);

            return Ok(retorno);
        }

        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {
            var local = localRepositorio.ObterLocal(id);

            if (local == null)
            {
                return NotFound("Não existe local com esse id");
            }

            return Ok(MapearLocalParaLocalResponse(local));
        }

        [HttpGet("/lista")]
        public IActionResult Get()
        {
            var lista = localRepositorio.ListarLocals();

            return Ok(lista);
        }

        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            localRepositorio.DeletarLocal(id);

            return Ok("Local removido");
        }

        [HttpPut("{id}")]
        public IActionResult Put(int id,[FromBody]LocalResquestDto localDto)
        {
            var local = MapearLocalRequestDtoParaLocal(localDto);

            localRepositorio.AtualizarLocal(id,local);

            return Ok("Registro alterado");
        }

        private LocalResponseDto MapearLocalParaLocalResponse(Local local)
        {
            return new LocalResponseDto(local.Id, local.Cidade, local.Aeroporto, local.Latitude, local.Longitude);
        }

        private Local MapearLocalRequestDtoParaLocal(LocalResquestDto localDto)
        {
            return new Local(localDto.Cidade, localDto.Aeroporto, localDto.Latitude, localDto.Longitude);
        }

    }
}