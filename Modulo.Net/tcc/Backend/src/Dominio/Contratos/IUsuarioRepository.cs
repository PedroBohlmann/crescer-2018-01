using System.Collections.Generic;
using Dominio.Entidades;

namespace Dominio.Contratos
{
    public interface IUsuarioRepository
    {
        void SalvarUsuario(Usuario trecho);

        void AtualizarUsuario(int id, Usuario trecho);

        void DeletarUsuario(int id);

        Usuario ObterUsuario(int id);

        List<Usuario> ListarUsuario(); 
    }
}