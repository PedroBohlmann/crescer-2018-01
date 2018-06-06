using System.Collections.Generic;
using Dominio.Entidades;

namespace Dominio.Servicos
{
    public class ClasseDeVooService
    {
        public List<string> Validar(ClasseDeVoo voo)
        {
            List<string> mensagens = new List<string>();

            if (string.IsNullOrEmpty(voo.Descricao))
            {
                mensagens.Add("Descricao é um campo obrigatorio");
            }
            if (voo.ValorFixo <= 0)
            {
                mensagens.Add("Valor fixo é um campo obrigatorio");
            }
            if (voo.ValorMilha <= 0)
            {
                mensagens.Add("Valor milha é um campo obrigatorio");
            }

            return mensagens;
        }
    }
}