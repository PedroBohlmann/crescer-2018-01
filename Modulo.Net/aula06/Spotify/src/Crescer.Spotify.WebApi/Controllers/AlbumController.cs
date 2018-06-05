using System.Collections.Generic;
using System.Linq;
using Crescer.Spotify.Dominio.Contratos;
using Crescer.Spotify.Dominio.Entidades;
using Crescer.Spotify.Dominio.Servicos;
using Crescer.Spotify.Infra;
using Crescer.Spotify.WebApi.Models.Request;
using Microsoft.AspNetCore.Mvc;

namespace Crescer.Spotify.WebApi.Controllers
{
    [Route("api/[controller]")]
    public class AlbumController : Controller
    {
        private IAlbumRepository albumRepository;
        private AlbumService albumService;

        private IAvaliacaoRepository avaliacaoRepository;

        private SpotifyContext contexto;
        public AlbumController(IAlbumRepository albumRepository, AlbumService albumService, SpotifyContext contexto, IAvaliacaoRepository avaliacaoRepository)
        {
            this.albumRepository = albumRepository;
            this.albumService = albumService;
            this.contexto = contexto;
            this.avaliacaoRepository = avaliacaoRepository;
        }

        //GET api/Album
        [HttpGet]
        public IActionResult Get()
        {
            return Ok(albumRepository.ListarAlbum());
        }

        // GET api/Album/{id}
        [HttpGet("{id}", Name = "GetAlbum")]
        public IActionResult Get(int id)
        {
            var album = albumRepository.Obter(id);

            if (album == null) return NotFound("Não existe album com esse id");

            return Ok(album);
        }

        // POST api/Album
        [HttpPost]
        public IActionResult Post([FromBody]Models.Request.AlbumDto albumRequest)//alterando
        {
            var album = MapearDtoParaDominio(albumRequest);
            var mensagens = albumService.Validar(album);
            if (mensagens.Count > 0)
                return BadRequest(mensagens);

            albumRepository.SalvarAlbum(album);

            contexto.SaveChanges();

            return CreatedAtRoute("GetAlbum", new { id = album.Id }, album);
        }

        // PUT api/Album/{id}
        [HttpPut("{id}")]
        public IActionResult Put(int id, [FromBody]Models.Request.AlbumDto albumRequest)
        {
            var albumTest = albumRepository.Obter(id);

            if (albumTest == null) return NotFound("Não existe album com esse id");

            var album = MapearDtoParaDominio(albumRequest);
            var mensagens = albumService.Validar(album);
            if (mensagens.Count > 0)
                return BadRequest(mensagens);

            albumRepository.AtualizarAlbum(id, album);

            contexto.SaveChanges();

            return Ok();
        }

        // DELETE api/Album/{id}
        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            var albumTest = albumRepository.Obter(id);

            if (albumTest == null) return NotFound("Não existe album com esse id");

            albumRepository.DeletarAlbum(id);

            contexto.SaveChanges();

            return Ok();
        }

        private Album MapearDtoParaDominio(Models.Request.AlbumDto album)
        {
            return new Album(album.Nome);
        }

        [HttpGet("{id}/avaliacao")]
        public IActionResult GetAvaliacao(int id)
        {
            var media = avaliacaoRepository.AvaliacaoAlbum(id);

            if (media == null) return NotFound("Não existe media para esse album");

            return Ok(media);
        }
    }
}