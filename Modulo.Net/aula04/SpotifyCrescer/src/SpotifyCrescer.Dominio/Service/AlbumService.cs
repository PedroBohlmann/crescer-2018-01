using System.Collections.Generic;
using SpotifyCrescer.Dominio.Model;

namespace SpotifyCrescer.Dominio.Service
{
    public class AlbumService
    {
        public List<string> VerificarInconsistencia(Album album)
        {
            var inconsistencias = new List<string>();

            if(string.IsNullOrEmpty(album.Nome))
            {
                inconsistencias.Add($"O campo {nameof(album.Nome)} está nulo");
                return inconsistencias;
            }

            return inconsistencias;
        }
    }
}