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
    public class ClasseDeVooController : Controller
    {
        private VooContext contexto;

        private IClasseDeVooRepository classeDeVooRepository;

        private ClasseDeVooService classeDeVooService;

        public ClasseDeVooController(VooContext contexto, IClasseDeVooRepository classeDeVooRepository, ClasseDeVooService classeDeVooService)
        {
            this.contexto = contexto;
            this.classeDeVooRepository = classeDeVooRepository;
            this.classeDeVooService = classeDeVooService;
        }

        [Authorize(Roles="Admin"),HttpPost]
        public IActionResult Post([FromBody]ClasseDeVooRequestDto classeDeVooDto)
        {
            var classeDeVoo = MapearClasseDeVooDtoParaClasseDeVoo(classeDeVooDto);

            var erros = classeDeVooService.Validar(classeDeVoo);

            if (erros.Count > 0)
            {
                return BadRequest(erros);
            }

            classeDeVooRepository.SalvarClasseDeVoo(classeDeVoo);

            contexto.SaveChanges();

            return Ok(MapearClasseDeVooParaResponse(classeDeVoo));
        }

        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {
            var classeDeVoo = classeDeVooRepository.ObterClasseDeVoo(id);

            if (classeDeVoo == null)
            {
                return NotFound("Não tem classe de voo com esse id");
            }

            return Ok(MapearClasseDeVooParaResponse(classeDeVoo));
        }

        [HttpGet]
        public IActionResult Get()
        {
            var lista = classeDeVooRepository.ListarClassesDeVoo();

            return Ok(lista);
        }

        [Authorize(Roles="Admin"),HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            classeDeVooRepository.DeletarClasseDeVoo(id);

            contexto.SaveChanges();

            return Ok("Classe de voo removida");
        }

        [Authorize(Roles="Admin"),HttpPut("{id}")]
        public IActionResult Put(int id, [FromBody]ClasseDeVooRequestDto classeDeVooDto)
        {
            var classeDeVoo = MapearClasseDeVooDtoParaClasseDeVoo(classeDeVooDto);

            var erros = classeDeVooService.Validar(classeDeVoo);

            if (erros.Count > 0)
            {
                return BadRequest(erros);
            }

            classeDeVooRepository.AtualizarClasseDeVoo(id,classeDeVoo);

            contexto.SaveChanges();

            return Ok("Alterado com Sucesso");
        }

        private ClasseDeVoo MapearClasseDeVooDtoParaClasseDeVoo(ClasseDeVooRequestDto classeDeVooDto)
        {
            return new ClasseDeVoo(classeDeVooDto.Descricao, classeDeVooDto.ValorFixo, classeDeVooDto.ValorMilha);
        }

        private ClasseDeVooResponseDto MapearClasseDeVooParaResponse(ClasseDeVoo classeDeVoo)
        {
            return new ClasseDeVooResponseDto(classeDeVoo.Id, classeDeVoo.Descricao, classeDeVoo.ValorFixo, classeDeVoo.ValorMilha);
        }
    }
}