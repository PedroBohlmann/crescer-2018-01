using System.Collections.Generic;
using Dominio.Entidades;

namespace Dominio.Contratos
{
    public interface IUsuarioRepository
    {
        void SalvarUsuario(Usuario trecho);

        Usuario ObterUsuarioPorEmailESenha(string Email,string senha);

        Usuario ObterUsuarioPorId(int id);
    }
}