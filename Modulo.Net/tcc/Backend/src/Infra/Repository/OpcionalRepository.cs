using System.Collections.Generic;
using System.Linq;
using Dominio.Contratos;
using Dominio.Entidades;

namespace Infra.Repository
{
    public class OpcionalRepository : IOpcionalRepository
    {
        private VooContext contexto;

        public OpcionalRepository(VooContext contexto)
        {
            this.contexto = contexto;
        }

        public void AtualizarOpcional(int id, Opcional opcional)
        {
            var opcionalSalvo = contexto.Opcional.FirstOrDefault(p => p.Id == id);
            opcionalSalvo.AtualizarOpcional(opcional);
        }

        public void DeletarOpcional(int id)
        {
            var opcionalSalvo = contexto.Opcional.FirstOrDefault(p => p.Id == id);
            contexto.Opcional.Remove(opcionalSalvo);
        }

        public List<Opcional> ListarOpcionais()
        {
            return contexto.Opcional.ToList();
        }

        public Opcional ObterOpcional(int id)
        {
            return contexto.Opcional.FirstOrDefault(p => p.Id == id);
        }

        public void SalvarOpcional(Opcional opcional)
        {
            contexto.Opcional.Add(opcional);
        }
    }
}