using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Api.Model.Request;
using Api.Model.Response;
using Dominio.Contratos;
using Dominio.Entidades;
using Dominio.Servicos;
using Infra;
using Microsoft.AspNetCore.Mvc;

namespace Api.Controllers 
{
    public class UsuarioController : Controller
    {
        private VooContext contexto;

        private IUsuarioRepository usuarioRepositorio;

        private UsuarioService usuarioService;

        
        
    }
}