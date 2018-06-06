using System.Collections.Generic;
using System.Linq;
using Dominio.Contratos;
using Dominio.Entidades;
using Microsoft.EntityFrameworkCore;

namespace Infra.Repository
{
    public class LocalRepository : ILocalRepository
    {

        private VooContext contexto;

        public LocalRepository(VooContext contexto)
        {
            this.contexto=contexto;
        }

        public void AtualizarLocal(int id, Local local)
        {
            var localSalvo = contexto.Locais.FirstOrDefault(p=>p.Id==id);
            localSalvo.AtualizarLocal(local);
        }

        public void DeletarLocal(int id)
        {
            var localSalvo = contexto.Locais.FirstOrDefault(p=>p.Id==id);
            contexto.Locais.Remove(localSalvo);
        }

        public List<Local> ListarLocals()
        {
            return contexto.Locais.AsNoTracking().ToList();
        }

        public Local ObterLocal(int id)
        {
            return contexto.Locais.FirstOrDefault(p=>p.Id==id);
        }

        public void SalvarLocal(Local local)
        {
            contexto.Locais.Add(local);
        }
    }
}