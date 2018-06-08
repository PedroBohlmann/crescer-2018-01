using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Security.Claims;
using System.Text;
using System.Threading.Tasks;
using Api.Model.Request;
using Api.Model.Response;
using Dominio.Contratos;
using Dominio.Entidades;
using Dominio.Servicos;
using Infra;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Options;
using Microsoft.IdentityModel.Tokens;

namespace Api.Controllers
{
    [Authorize, Route("api/usuario")]
    public class UsuarioController : Controller
    {
        private VooContext contexto;

        private IUsuarioRepository usuarioRepositorio;

        private UsuarioService usuarioService;

        private IOptions<SecuritySettings> settings;

        public UsuarioController(VooContext contexto, UsuarioService usuarioService,
                                IUsuarioRepository usuarioRepositorio, IOptions<SecuritySettings> settings)
        {
            this.contexto = contexto;
            this.usuarioRepositorio = usuarioRepositorio;
            this.usuarioService = usuarioService;
            this.settings = settings;
        }

        [AllowAnonymous,HttpPost("/criarUsuario")]
        public IActionResult HttpPost([FromBody]UsuarioRequestDto usuarioDto)
        {
            var usuario = MapearUsuarioDtoParaUsuario(usuarioDto);

            var erros = usuarioService.Validar(usuario);
            if(erros.Count>0)
            {
                return BadRequest(erros);
            }

            usuarioRepositorio.SalvarUsuario(usuario);

            contexto.SaveChanges();

            return Ok(MapearUsarioParaResponse(usuario));
        }

        [AllowAnonymous,HttpPost("/login")]
        public IActionResult Login([FromBody]LoginResquest login)
        {
            var usuario = usuarioRepositorio.ObterUsuarioPorEmailESenha(login.Email,login.Senha);

            if(usuario == null) return BadRequest("Usuario ou senha invalido");

            var signingKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(settings.Value.SigningKey));
            var signingCredentials = new SigningCredentials(signingKey, SecurityAlgorithms.HmacSha256);

            var role = usuario.Admin? "Admin":"Usuario";

            var token = new JwtSecurityToken(
                claims: new[] {
                    new Claim(ClaimTypes.Name, usuario.PrimeiroNome),
                    new Claim(ClaimTypes.Role, role),
                },
                expires: DateTime.Now.AddMinutes(30),
                signingCredentials: signingCredentials);

            return Ok(new
            {
                token = new JwtSecurityTokenHandler().WriteToken(token)
            });
        }

        private UsuarioResponseDto MapearUsarioParaResponse(Usuario usuario)
        {
            return new UsuarioResponseDto(usuario.Id,usuario.PrimeiroNome,usuario.UltimoNome,usuario.Cpf,usuario.DataNascimento,usuario.Email);
        }

        private Usuario MapearUsuarioDtoParaUsuario(UsuarioRequestDto usuarioDto)
        {
            return new Usuario(usuarioDto.PrimeiroNome,usuarioDto.UltimoNome,usuarioDto.Cpf,
                                usuarioDto.DataNascimento,usuarioDto.Email,usuarioDto.Senha);
        }
    }
}