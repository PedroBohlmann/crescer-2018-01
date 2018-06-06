using System.Collections.Generic;
using Dominio.Entidades;

namespace Dominio.Contratos
{
    public interface ILocalRepository
    {
        void SalvarLocal(Local local);
        void AtualizarLocal(int id, Local local);

        void DeletarLocal(int id);

        Local ObterLocal(int id);

        List<Local> ListarLocals();
    }
}