using System.Collections.Generic;
using System.Linq;
using Dominio.Contratos;
using Dominio.Entidades;

namespace Infra.Repository
{
    public class ClasseDeVooRepository : IClasseDeVooRepository
    {
        private VooContext contexto;

        public ClasseDeVooRepository(VooContext contexto)
        {
            this.contexto = contexto;
        }


        public void AtualizarClasseDeVoo(int id, ClasseDeVoo classeDeVoo)
        {
            var classeDeVooSalva = contexto.ClassesDeVoo.FirstOrDefault(p => p.Id == id);
            classeDeVooSalva.AtualizarClasseDeVoo(classeDeVoo);
        }

        public void DeletarClasseDeVoo(int id)
        {
            var classeDeVooSalva = contexto.ClassesDeVoo.FirstOrDefault(p => p.Id == id);
            contexto.ClassesDeVoo.Remove(classeDeVooSalva);
        }

        public List<ClasseDeVoo> ListarClassesDeVoo()
        {
            return contexto.ClassesDeVoo.ToList();
        }

        public ClasseDeVoo ObterClasseDeVoo(int id)
        {
            return contexto.ClassesDeVoo.FirstOrDefault(p => p.Id == id);
        }

        public void SalvarClasseDeVoo(ClasseDeVoo classeDeVoo)
        {
            contexto.ClassesDeVoo.Add(classeDeVoo);
        }
    }
}