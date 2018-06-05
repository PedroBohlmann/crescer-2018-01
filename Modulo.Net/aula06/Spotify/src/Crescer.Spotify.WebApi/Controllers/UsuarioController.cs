using System.Collections.Generic;
using System.Linq;
using Crescer.Spotify.Dominio.Contratos;
using Crescer.Spotify.Dominio.Entidades;
using Crescer.Spotify.Dominio.Servicos;
using Crescer.Spotify.Infra;
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

        private SpotifyContext contexto;

        private IAvaliacaoRepository avaliacaoRepository;

        private AvaliacaoService avaliacaoService;

        private IMusicaRepository musicaRepository;

        public UsuarioController(IUsuarioRepository usuarioRepository,
                                UsuarioService usuarioService, SpotifyContext contexto,
                                IAvaliacaoRepository avaliacaoRepository, AvaliacaoService avaliacaoService,
                                IMusicaRepository musicaRepository)
        {
            this.usuarioRepository = usuarioRepository;
            this.usuarioService = usuarioService;
            this.contexto = contexto;
            this.avaliacaoRepository = avaliacaoRepository;
            this.avaliacaoService = avaliacaoService;
            this.musicaRepository = musicaRepository;
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

            contexto.SaveChanges();

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
            contexto.SaveChanges();
            return Ok("Deletado com sucesso");
        }

        [HttpPut("{id}")]
        public IActionResult Put(int id, [FromBody]UsuarioDto usuarioDto)
        {
            if (usuarioRepository.Obter(id) == null) { return NotFound("Não existe usuario com esse id"); }

            var usuario = new Usuario(usuarioDto.Nome);
            var mensagens = usuarioService.Validar(usuario);
            if (mensagens.Count > 0)
            {
                return BadRequest(mensagens);
            }

            usuarioRepository.AtualizarUsuario(id, usuario);

            contexto.SaveChanges();

            return Ok("Dados atualizados");
        }

        [HttpPost("/usuario/avaliacao")]
        public IActionResult Post([FromBody]AvaliacaoDto avaliacaoDto)
        {
            var usuario= usuarioRepository.Obter(avaliacaoDto.IdUsuario);

            var musica = musicaRepository.Obter(avaliacaoDto.IdMusica);

            if (usuario == null) { return NotFound("Não existe usuario com esse id"); }

            if (musica == null) return NotFound("Não existe musica com esse id");

            Avaliacao avaliacao = new Avaliacao(musica,usuario,avaliacaoDto.Nota);
            
            var mensagens = avaliacaoService.Validar(avaliacao);
            if (mensagens.Count > 0)
            {
                return BadRequest(mensagens);
            }

            avaliacaoRepository.SalvarAvaliacao(avaliacao);

            contexto.SaveChanges();

            return Ok("Nova avaliacao");
        }
    }
}