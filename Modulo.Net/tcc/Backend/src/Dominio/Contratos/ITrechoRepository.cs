using System.Collections.Generic;
using Dominio.Entidades;

namespace Dominio.Contratos
{
    public interface ITrechoRepository
    {
        void SalvarTrecho(Trecho trecho);

        void AtualizarTrecho(int id, Trecho trecho);

        void DeletarTrecho(int id);

        Trecho ObterTrecho(int id);

        List<Trecho> ListarTrechos(); 
    }
}