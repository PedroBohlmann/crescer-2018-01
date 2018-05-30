using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using LojinhaDoCrescer.Dominio.Entidades;
using Microsoft.AspNetCore.Mvc;

using LojinhaDoCrescer.Api.Model;
using LojinhaDoCrescer.Dominio.Services;
using LojinhaDoCrescer.Infra;

namespace LojinhaDoCrescer.Api.Controllers
{
    [Route("api/[controller]")]
    public class ProdutoController : Controller
    {
        [HttpGet("{id}", Name ="GetProduto")]
        public ActionResult Get(int id){
            var produtoRepository = new ProdutoRepository();

            var produto = produtoRepository.Buscar(id);

            if(produto==null){
                return BadRequest("Não tem ninguem com esse id");
            }

            return Ok(produto);
        }


        [HttpPost]
        public ActionResult Post([FromBody] ProdutoRequestDTO produtoDto)
        {
            var produto =new Produto(produtoDto.Descricao,produtoDto.Valor);
            var produtoService = new ProdutoService();

            var inconsistencias = produtoService.VerificarInconsistenciasEmUmNovoProduto(produto);

            if(inconsistencias.Any()==true){
                return BadRequest(inconsistencias);
            }

            var produtos =  new ProdutoRepository();
            produtos.Salvar(produto);

            return CreatedAtRoute("GetProduto", new {id= produto.Id},produto);
        }
    }
}
