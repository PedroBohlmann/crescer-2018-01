using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using SpotifyCrescer.Dominio.Model;
using SpotifyCrescer.Infra;
using SpotifyCrescer.Api.Models;
using SpotifyCrescer.Dominio.Service;
using SpotifyCrescer.Dominio.Contratos;

namespace SpotifyCrescer.Api.Controllers
{
    [Route("api/[controller]")]
    public class AlbumController : Controller
    {
        private IAlbumRepository database;

        private AlbumService albumService;

        public AlbumController(IAlbumRepository albumRepository,AlbumService albumService)
        {
            database=albumRepository;
            this.albumService=albumService;
        }

        [HttpPost]
        public ActionResult PostDeNovoAlbum([FromBody]AlbumRequestDTO albumDTO)
        {
            var album = new Album(albumDTO.Nome);

            var inconsistencias = albumService.VerificarInconsistencia(album);

            if (inconsistencias.Any()) return BadRequest(inconsistencias);

            database.InsereNovoAlbum(album);

            return CreatedAtRoute("GetAlbumPeloId", new { id = album.Id }, album);
        }

        [HttpGet("{id}", Name = "GetAlbumPeloId")]
        public ActionResult GetAlbumPeloId(int id)
        {
            var album = database.BuscaAlbumPorId(id);

            if (album == null)
            {
                return NotFound("Não existe album com esse id");
            }

            return Ok(album);
        }

        [HttpGet]
        public ActionResult GetTodosOsAlbums()
        {
            return Ok(database.TodosOsAlbums());
        }

        [HttpPut("{id}")]
        public ActionResult PutAtualizaAlbum(int id,[FromBody]AlbumRequestDTO albumDTO)
        {
            var album = database.BuscaAlbumPorId(id);

            if (album == null)
            {
                return NotFound("Não existe album com esse id");
            }

            var albumAtualizado = new Album(albumDTO.Nome);
            
            albumAtualizado.Id = album.Id;

            List<Musica> musicasDoAlbum = album.Musicas;

            foreach(Musica musica in musicasDoAlbum){
                albumAtualizado.AdicionarMusica(musica);
            }

            database.AtualizaAlbum(albumAtualizado);

            return Ok("Album atualizado");
        }

        [HttpDelete("{id}")]
        public ActionResult DeleteAlbumPeloId(int id)
        {
            var album = database.BuscaAlbumPorId(id);

            if (album == null)
            {
                return NotFound("Não existe album com esse id");
            }

            database.RemoveAlbumPorId(id);

            return Ok("Album removido");
        }
    }
}
