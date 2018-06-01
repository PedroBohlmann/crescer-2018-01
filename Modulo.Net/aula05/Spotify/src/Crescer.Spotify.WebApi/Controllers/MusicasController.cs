using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Crescer.Spotify.Dominio.Contratos;
using Crescer.Spotify.Dominio.Entidades;
using Crescer.Spotify.Dominio.Servicos;
using Crescer.Spotify.Infra;
using Microsoft.AspNetCore.Mvc;

namespace Crescer.Spotify.WebApi.Controllers
{
    [Route("api/album")]
    public class MusicasController : Controller
    {
        private IMusicaRepository musicaRepository;
        private IAlbumRepository albumRepository;
        private MusicaService musicaService;

        public MusicasController(IMusicaRepository musicaRepository, MusicaService musicaService, IAlbumRepository albumRepository)
        {
            this.musicaRepository = musicaRepository;
            this.musicaService = musicaService;
            this.albumRepository = albumRepository;
        }
        // GET api/values
        [HttpGet("{idAlbum}/musica")]
        public IActionResult Get(int idAlbum)
        {
            if (albumRepository.Obter(idAlbum) == null) return NotFound();

            var listaMusicas = musicaRepository.ListarMusicas(idAlbum);
            if (listaMusicas == null) return NotFound();

            return Ok(musicaRepository.ListarMusicas(idAlbum));
        }

        // GET api/values/5
        [HttpGet("{idAlbum}/musica/{id}", Name = "GetMusica")]
        public IActionResult Get(int idAlbum, int id)
        {
            var musica = musicaRepository.Obter(idAlbum, id);

            if (musica == null) return NotFound();

            return Ok(musica);
        }

        // POST api/values
        [HttpPost("{idAlbum}/musica")]
        public IActionResult Post(int idAlbum, [FromBody]Models.Request.MusicaDto musicaRequest)
        {
            if (albumRepository.Obter(idAlbum) == null) return NotFound();

            var musica = MapearDtoParaDominio(musicaRequest);
            var mensagens = musicaService.Validar(musica);
            if (mensagens.Count > 0)
                return BadRequest(mensagens);

            musicaRepository.SalvarMusica(idAlbum, musica);
            return CreatedAtRoute("GetMusica", new { idAlbum = idAlbum, id = musica.Id }, musica);
        }

        // PUT api/values/5
        [HttpPut("{idAlbum}/musica/{id}")]
        public IActionResult Put(int idAlbum, int id, [FromBody]Models.Request.MusicaDto musicaRequest)
        {
            if (albumRepository.Obter(idAlbum) == null) return NotFound();

            var musica = MapearDtoParaDominio(musicaRequest);
            var mensagens = musicaService.Validar(musica);
            if (mensagens.Count > 0)
                return BadRequest(mensagens);

            musicaRepository.AtualizarMusica(idAlbum, id, musica);
            return Ok();
        }

        // DELETE api/values/5
        [HttpDelete("{idAlbum}/musica/{id}")]
        public IActionResult Delete(int idAlbum, int id)
        {
            if (albumRepository.Obter(idAlbum) == null) return NotFound();

            musicaRepository.DeletarMusica(idAlbum, id);
            return Ok();
        }

        private Musica MapearDtoParaDominio(Models.Request.MusicaDto musica)
        {
            return new Musica(musica.Nome, musica.Duracao);
        }
    }
}