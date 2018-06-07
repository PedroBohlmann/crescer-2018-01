using System.Collections.Generic;
using Dominio.Entidades;

namespace Dominio.Contratos
{
    public interface IClasseDeVooRepository
    {
        void SalvarClasseDeVoo(ClasseDeVoo classeDeVoo);

        void AtualizarClasseDeVoo(int id, ClasseDeVoo classeDeVoo);

        void DeletarClasseDeVoo(int id);

        ClasseDeVoo ObterClasseDeVoo(int id);

        List<ClasseDeVoo> ListarClassesDeVoo();
    }
}