using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using PetStore.Dominio.Entidades;
using PetStore.Dominio;
using PetStore.Api.Models;

namespace UsuarioStore.Api.Controllers
{
    [Route("api/[controller]")]
    public class UsuariosController : Controller
    {
        public UsuariosController()
        {

        }

        [HttpGet]
        public IActionResult BuscarUsuarios()
        {
            return Ok();
        }

        [HttpGet("{login}", Name = "GetUsuario")]
        public IActionResult BuscarUsuarioPorLogin(string login)
        {
            return Ok();
        }

        [HttpPost]
        public IActionResult CriarUsuario([FromBody]UsuarioRequestDTO usuario)
        {
            return Ok();
        }

        [HttpPut("{login}")]
        public IActionResult AlterarUsuario(string login, [FromBody]UsuarioRequestDTO usuarioAtualizado)
        {
            return Ok();
        }

        [HttpDelete("{login}")]
        public IActionResult RemoverUsuario(string login)
        {
            return Ok();
        }

        [HttpPost("login")]
        [HttpPost("logout")]
        public IActionResult LoginELogout([FromBody]DadosLoginRequestDTO dadosLogin)
        {
            return Ok();
        }
    }
}