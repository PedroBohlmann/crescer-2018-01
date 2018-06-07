using System.Collections.Generic;
using Dominio.Entidades;

namespace Dominio.Contratos
{
    public interface IOpcionalRepository
    {
        void SalvarOpcional(Opcional opcional);

        void AtualizarOpcional(int id, Opcional opcional);

        void DeletarOpcional(int id);

        Opcional ObterOpcional(int id);

        List<Opcional> ListarOpcionais();
    }
}