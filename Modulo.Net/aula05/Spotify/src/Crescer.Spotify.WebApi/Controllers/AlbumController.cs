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
    public class AlbumController : Controller
    {
        private IAlbumRepository albumRepository;
        private AlbumService albumService;

        private Database database;
        public AlbumController(IAlbumRepository albumRepository, AlbumService albumService, Database database)
        {
            this.albumRepository = albumRepository;
            this.albumService = albumService;
            this.database = database;
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

            if (album == null) return NotFound();

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

            database.Commit();

            return CreatedAtRoute("GetAlbum", new { id = album.Id }, album);
        }

        // PUT api/Album/{id}
        [HttpPut("{id}")]
        public IActionResult Put(int id, [FromBody]Models.Request.AlbumDto albumRequest)
        {
            var album = MapearDtoParaDominio(albumRequest);
            var mensagens = albumService.Validar(album);
            if (mensagens.Count > 0)
                return BadRequest(mensagens);

            albumRepository.AtualizarAlbum(id, album);
            database.Commit();
            return Ok();
        }

        // DELETE api/Album/{id}
        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            albumRepository.DeletarAlbum(id);
            database.Commit();
            return Ok();
        }

        private Album MapearDtoParaDominio(Models.Request.AlbumDto album)
        {
            return new Album(album.Nome);
        }
    }
}