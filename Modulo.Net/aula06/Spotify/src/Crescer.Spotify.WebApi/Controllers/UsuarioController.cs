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

        private IAvaliacaoRepository avaliacaoRepository;

        private AvaliacaoService avaliacaoService;

        private IMusicaRepository musicaRepository;

        public UsuarioController(IUsuarioRepository usuarioRepository, 
                                UsuarioService usuarioService, Database database, 
                                IAvaliacaoRepository avaliacaoRepository, AvaliacaoService avaliacaoService,
                                IMusicaRepository musicaRepository)
        {
            this.usuarioRepository = usuarioRepository;
            this.usuarioService = usuarioService;
            this.database = database;
            this.avaliacaoRepository = avaliacaoRepository;
            this.avaliacaoService=avaliacaoService;
            this.musicaRepository=musicaRepository;
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
            if (usuarioRepository.Obter(id) == null) { return NotFound("Não existe usuario com esse id"); }

            usuarioRepository.DeletarUsuario(id);
            database.Commit();
            return Ok("Deletado com sucesso");
        }

        [HttpPut("{id}")]
        public IActionResult Put(int id,[FromBody]UsuarioDto usuarioDto)
        {
            if (usuarioRepository.Obter(id) == null) { return NotFound("Não existe usuario com esse id"); }

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

        [HttpPost("/usuario/avaliacao")]
        public IActionResult Post([FromBody]AvaliacaoDto avaliacaoDto)
        {
            Avaliacao avaliacao = null;//new Avaliacao(avaliacaoDto.IdMusica,avaliacaoDto.IdUsuario,avaliacaoDto.Nota);
            var mensagens = avaliacaoService.Validar(avaliacao);
            if (mensagens.Count > 0)
            {
                return BadRequest(mensagens);
            }

            if (usuarioRepository.Obter(avaliacao.Usuario.Id) == null) { return NotFound("Não existe usuario com esse id"); }
            
            if (musicaRepository.Obter(avaliacao.Musica.Id) == null) return NotFound("Não existe musica com esse id");

            avaliacaoRepository.SalvarAvaliacao(avaliacao);

            database.Commit();

            return Ok("Nova avaliacao");
        }
    }
}