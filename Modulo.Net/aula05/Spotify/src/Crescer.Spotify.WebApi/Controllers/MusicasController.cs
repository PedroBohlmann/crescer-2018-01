using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Crescer.Spotify.Dominio.Contratos;
using Crescer.Spotify.Dominio.Entidades;
using Crescer.Spotify.Dominio.Servicos;
using Crescer.Spotify.Infra;
using Crescer.Spotify.WebApi.Models.Request;
using LojinhaDoCrescer.Infra;
using Microsoft.AspNetCore.Mvc;

namespace Crescer.Spotify.WebApi.Controllers
{
    [Route("api/album")]
    public class MusicasController : Controller
    {
        private IMusicaRepository musicaRepository;
        private IAlbumRepository albumRepository;

        private IAvaliacaoRepository avaliacaoRepository;

        private MusicaService musicaService;

        private Database database;

        public MusicasController(IMusicaRepository musicaRepository, MusicaService musicaService,
                                IAlbumRepository albumRepository, Database database, IAvaliacaoRepository avaliacaoRepository)
        {
            this.musicaRepository = musicaRepository;
            this.musicaService = musicaService;
            this.albumRepository = albumRepository;
            this.database = database;
            this.avaliacaoRepository = avaliacaoRepository;
        }

        // GET api/{idAlbum}/Musica/lista
        [HttpGet("{idAlbum}/musica/lista")]
        public IActionResult GetTodasMusicas(int idAlbum)
        {
            if (albumRepository.Obter(idAlbum) == null) return NotFound();

            var listaMusicas = musicaRepository.ListarMusicas(idAlbum);
            if (listaMusicas == null) return NotFound();

            return Ok(musicaRepository.ListarMusicas(idAlbum));
        }

        // GET api/album/musica/{id}
        [HttpGet("album/musica/{id}", Name = "GetMusica")]
        public IActionResult Get(int id)
        {
            var musica = musicaRepository.Obter(id);

            if (musica == null) return NotFound();

            return Ok(musica);
        }

        // POST api/album/{idAlbum}/musica
        [HttpPost("album/{idAlbum}/musica")]
        public IActionResult Post(int idAlbum, [FromBody]Models.Request.MusicaDto musicaRequest)
        {
            if (albumRepository.Obter(idAlbum) == null) return NotFound();

            var musica = MapearDtoParaDominio(musicaRequest);
            var mensagens = musicaService.Validar(musica);
            if (mensagens.Count > 0)
                return BadRequest(mensagens);

            musicaRepository.SalvarMusica(idAlbum, musica);
            database.Commit();
            return CreatedAtRoute("GetMusica", new { id = musica.Id }, musica);
        }

        // PUT api/album/{idAlbum}/musica/{id}
        [HttpPut("album/{idAlbum}/musica/{id}")]
        public IActionResult Put(int idAlbum, int id, [FromBody]Models.Request.MusicaDto musicaRequest)
        {
            if (albumRepository.Obter(idAlbum) == null) return NotFound();

            var musica = MapearDtoParaDominio(musicaRequest);
            var mensagens = musicaService.Validar(musica);
            if (mensagens.Count > 0)
                return BadRequest(mensagens);

            musicaRepository.AtualizarMusica(idAlbum, id, musica);

            database.Commit();
            return Ok();
        }

        // DELETE api/values/5
        [HttpDelete("album/{idAlbum}/musica/{id}")]
        public IActionResult Delete(int idAlbum, int id)
        {
            if (albumRepository.Obter(idAlbum) == null) return NotFound();

            musicaRepository.DeletarMusica(idAlbum, id);

            database.Commit();
            return Ok();
        }

        private Musica MapearDtoParaDominio(Models.Request.MusicaDto musica)
        {
            return new Musica(musica.Nome, musica.Duracao);
        }

        [HttpGet("/album/musica/{id}/avaliacao")]
        public IActionResult GetAvaliacao(int id)
        {
            var media = avaliacaoRepository.MediaAvaliacoes(id);

            return Ok(media);
        }
    }
}