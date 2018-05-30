using System.Collections.Generic;
using SpotifyCrescer.Dominio.Model;

namespace SpotifyCrescer.Dominio.Service
{
    public class MusicaService
    {
        public List<string> VerificarInconsistencia(Musica musica)
        {
            var inconsistencias = new List<string>();

            if(string.IsNullOrEmpty(musica.Nome)){
                inconsistencias.Add($"O campo {nameof(musica.Nome)} está nulo");
                return inconsistencias;
            }
            if(musica.Duracao<=0){
                inconsistencias.Add($"O campo {nameof(musica.Duracao)} está nulo");
                return inconsistencias;
            }

            return inconsistencias;
        }
    }
}