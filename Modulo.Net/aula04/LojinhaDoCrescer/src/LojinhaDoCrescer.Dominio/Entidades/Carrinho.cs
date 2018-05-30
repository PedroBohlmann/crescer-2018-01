using System.Collections.Generic;

namespace LojinhaDoCrescer.Dominio.Entidades
{
    public class Carrinho
    {
        public Carrinho()
        {
            this.Produtos = new List<Produto>();

        }
        public int Id { get; set; }//set deveria ser privado

        public List<Produto> Produtos { get; private set; }

        public decimal ValorTotal { get; private set; }

        public void AdicionarProduto(Produto produto, int quantidade)
        {
            Produtos.Add(produto);
            ValorTotal += quantidade * produto.Valor;
        }
    }
}