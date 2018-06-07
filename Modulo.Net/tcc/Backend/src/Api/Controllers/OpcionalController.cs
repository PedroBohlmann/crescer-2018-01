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
    public class OpcionalController : Controller
    {
        private VooContext contexto;

        private OpcionalService opcionalService;

        private IOpcionalRepository opcionalRepository;

        public OpcionalController(VooContext contexto, OpcionalService opcionalService,IOpcionalRepository opcionalRepository)
        {
            this.contexto=contexto;
            this.opcionalService=opcionalService;
            this.opcionalRepository=opcionalRepository;
        }

        [HttpPost]
        public IActionResult Post([FromBody]OpcionalRequestDto opcionalDto)
        {
            var opcional = MapearOpcionalDtoParaOpcional(opcionalDto);

            opcionalRepository.SalvarOpcional(opcional);

            contexto.SaveChanges();

            return Ok(MapearOpcionalParaResponse(opcional));
        }
        
        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {
            var opcional = opcionalRepository.ObterOpcional(id);

            if(opcional==null)
            {
                return NotFound("Não existe opcional com esse id");
            }

            return Ok(MapearOpcionalParaResponse(opcional));
        }

        [HttpGet("/opcionais/lista")]
        public IActionResult Get()
        {
            var lista = opcionalRepository.ListarOpcionais();

            return Ok(lista);
        }

        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            opcionalRepository.DeletarOpcional(id);

            contexto.SaveChanges();

            return Ok("Opcional removido");
        }

        [HttpPut("{id}")]
        public IActionResult Put(int id,[FromBody]OpcionalRequestDto opcionalDto)
        {
            var opcional = MapearOpcionalDtoParaOpcional(opcionalDto);

            opcionalRepository.AtualizarOpcional(id,opcional);

            contexto.SaveChanges();

            return Ok("Opcional atualizado");
        }



        private Opcional MapearOpcionalDtoParaOpcional(OpcionalRequestDto opcionalDto)
        {
            return new Opcional(opcionalDto.Nome,opcionalDto.Descricao,opcionalDto.ValorPorcentagem);
        }

        private OpcionalResponseDto MapearOpcionalParaResponse(Opcional opcional)
        {
            return new OpcionalResponseDto(opcional.Id,opcional.Nome,opcional.Descricao,opcional.ValorPorcentagem);
        }
    }
}