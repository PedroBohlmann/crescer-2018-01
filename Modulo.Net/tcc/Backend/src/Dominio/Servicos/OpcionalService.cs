using System.Collections.Generic;
using Dominio.Entidades;

namespace Dominio.Servicos
{
    public class OpcionalService
    {
        public List<string> Validar(Opcional optional)
        {
            List<string> mensagens = new List<string>();

            if(string.IsNullOrEmpty(optional.Nome))
            {
                mensagens.Add("Campo nome é obrigatorio");
            }
            if(string.IsNullOrEmpty(optional.Descricao))
            {
                mensagens.Add("Campo descrição é obrigatorio");
            }
            if(optional.ValorPorcentagem<0||optional.ValorPorcentagem>1)
            {
                mensagens.Add("O valor porcentagem precisa estar entre 0 e 1");
            }

            return mensagens;
        }
    }
}