using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

using Crescer.PetStore.Api.Model;
using Crescer.PetStore.Api.Model.Enum;

namespace Crescer.PetStore.Api.Controllers
{
    [Route("api/[controller]")]
    public class UsuarioController : Controller
    {
        public static List<Usuario> listaDeUsuarios = new List<Usuario>();

        private static int id=1;

        // GET usuario/values
        [HttpGet]
        public List<Usuario> Get()
        {
            return listaDeUsuarios;
        }

        [HttpPost]
        public ActionResult Post([FromBody]Usuario newUser)
        {
            var procuraUser = listaDeUsuarios.FirstOrDefault(user=>user.Login==newUser.Login);

            if(procuraUser==null){
                newUser.Id=id++;
                listaDeUsuarios.Add(newUser);
                return Ok(newUser);
            }

            return BadRequest("Login em uso");
        }

    }
}