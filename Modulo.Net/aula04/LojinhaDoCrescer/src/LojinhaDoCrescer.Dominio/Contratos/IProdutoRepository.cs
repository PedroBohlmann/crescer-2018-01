using LojinhaDoCrescer.Dominio.Entidades;

namespace LojinhaDoCrescer.Dominio.Contratos
{
    public interface IProdutoRepository
    {
        void Salvar(Produto produto);

        Produto Buscar(int id);
    }
}