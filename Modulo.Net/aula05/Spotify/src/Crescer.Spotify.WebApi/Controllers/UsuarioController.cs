using System.Collections.Generic;
using System.Linq;
using Crescer.Spotify.Dominio.Contratos;
using Crescer.Spotify.Dominio.Entidades;
using Crescer.Spotify.Dominio.Servicos;
using Crescer.Spotify.WebApi.Models.Request;
using LojinhaDoCrescer.Infra;
using Microsoft.AspNetCore.Mvc;

namespace Crescer.Spotify.WebApi.Controllers
{
    [Route("api/[controller]")]
    public class UsuarioController : Controller
    {
        private IUsuarioRepository usuarioRepository;

        private UsuarioService usuarioService;

        private Database database;

        public UsuarioController(IUsuarioRepository usuarioRepository, UsuarioService usuarioService, Database database)
        {
            this.usuarioRepository = usuarioRepository;
            this.usuarioService = usuarioService;
            this.database = database;
        }

        [HttpPost]
        public IActionResult Post([FromBody]UsuarioDto usuarioDto)
        {
            var usuario = new Usuario(usuarioDto.Nome);
            var mensagens = usuarioService.Validar(usuario);
            if (mensagens.Count > 0)
            {
                return BadRequest(mensagens);
            }

            usuarioRepository.SalvarUsuario(usuario);

            database.Commit();

            return CreatedAtRoute("GetUsuario", new { id = usuario.Id }, usuario);
        }

        [HttpGet("{id}", Name = "GetUsuario")]
        public IActionResult Get(int id)
        {
            var usuario = usuarioRepository.Obter(id);

            if (usuario == null) { return NotFound("Não existe usuario com esse id"); }

            return Ok(usuario);
        }

        [HttpGet]
        public IActionResult Get()
        {
            return Ok(usuarioRepository.ListarUsuarios());
        }

        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            usuarioRepository.DeletarUsuario(id);
            database.Commit();
            return Ok("Deletado com sucesso");
        }

        [HttpPut("{id}")]
        public IActionResult Put(int id,[FromBody]UsuarioDto usuarioDto)
        {
            var usuario = new Usuario(usuarioDto.Nome);
            var mensagens = usuarioService.Validar(usuario);
            if (mensagens.Count > 0)
            {
                return BadRequest(mensagens);
            }

            usuarioRepository.AtualizarUsuario(id,usuario);
        
            database.Commit();

            return Ok("Dados atualizados");
        }
    }
}