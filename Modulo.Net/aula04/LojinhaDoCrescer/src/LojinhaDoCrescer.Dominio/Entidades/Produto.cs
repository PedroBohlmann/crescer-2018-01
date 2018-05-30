using System;

namespace LojinhaDoCrescer.Dominio.Entidades
{
    public class Produto
    {

        public Produto(string descricao, decimal valor)
        {
            this.Descricao = descricao;
            this.Valor = valor;

        }

        public int Id { get; set; }

        public string Descricao { get; private set; }

        public decimal Valor { get; private set; }
    }
}
