using System;
using System.Collections.Generic;
using System.Linq;
using LojinhaDoCrescer.Dominio.Contratos;
using LojinhaDoCrescer.Dominio.Entidades;

namespace LojinhaDoCrescer.Infra
{
    public class ProdutoRepository : IProdutoRepository
    {
        private static List<Produto> produtos = new List<Produto>();

        private static int idAtual=1;
        public Produto Buscar(int id)
        {
            return produtos.FirstOrDefault(produto => produto.Id==id);
        }

        public void Salvar(Produto produto)
        {
            produto.Id=idAtual++;
            produtos.Add(produto);
        }
    }
}
