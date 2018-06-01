using System.Collections.Generic;
using System.Linq;
using Crescer.Spotify.Dominio.Contratos;
using Crescer.Spotify.Dominio.Entidades;
using Dapper;
using LojinhaDoCrescer.Infra;

namespace Crescer.Spotify.Infra.Repository
{
    public class AlbumRepository : IAlbumRepository
    {

        private Database database;

        public AlbumRepository(Database database){
            this.database = database;
        }
        public void AtualizarAlbum(int id, Album album)
        {
            var albumObtido = Obter(id);
            albumObtido?.Atualizar(album);            
        }

        public void DeletarAlbum(int id)
        {
            var album = this.Obter(id);
            Repositorio.albuns.Remove(album);
        }

        public List<Album> ListarAlbum()
        {
            return database.Connection.Query<Album>(@"
                SELECT   
                     *
                FROM [dbo].[Album]
                ",null,database.Transaction).ToList();
        }

        public Album Obter(int id)
        {
            return Repositorio.albuns.Where(x => x.Id == id).FirstOrDefault();
        }

        public void SalvarAlbum(Album album)
        {
            int id = database.Connection.Query<int>(@"
                INSERT INTO [dbo].[Album]
                    ([Nome])
                VALUES
                    (
                      @Nome);
                SELECT CAST(SCOPE_IDENTITY() as int)", new { album.Nome }, database.Transaction).Single();
            album.Id=id;
        }     
    }
}