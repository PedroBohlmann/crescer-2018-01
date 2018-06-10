using System.Collections.Generic;
using System.Linq;
using Dominio.Contratos;
using Dominio.Entidades;
using Microsoft.EntityFrameworkCore;

namespace Infra.Repository
{
    public class TrechoRepository : ITrechoRepository
    {

        private VooContext contexto;

        public TrechoRepository(VooContext contexto)
        {
            this.contexto = contexto;
        }

        public void AtualizarTrecho(int id, Trecho trecho)
        {
            var trechoSalvo = contexto.Trechos.Include(p => p.Destino).Include(p => p.Origem).FirstOrDefault(p => p.Id == id);
            trechoSalvo.AtualizarTrecho(trecho);
        }

        public void DeletarTrecho(int id)
        {
            var trechoSalvo = contexto.Trechos.FirstOrDefault(p => p.Id == id);
            contexto.Trechos.Remove(trechoSalvo);
        }

        public List<Trecho> ListarTrechos()
        {
            return contexto.Trechos.Include(p => p.Destino).Include(p => p.Origem).ToList();
        }

        public Trecho ObterTrecho(int id)
        {
            return contexto.Trechos.Include(p => p.Destino).Include(p => p.Origem).FirstOrDefault(p => p.Id == id);
        }

        public void SalvarTrecho(Trecho trecho)
        {
            contexto.Trechos.Add(trecho);
        }
    }
}