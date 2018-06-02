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
            database.Connection.Execute(@"
                UPDATE [dbo].[Album]
                SET [Nome]=@Nome
                WHERE [AlbumId]=@Id
            ",new {id,album.Nome},database.Transaction);           
        }

        public void DeletarAlbum(int id)
        {
            database.Connection.Execute(@"
                DELETE [dbo].[Album]
                WHERE [AlbumId] = @Id
            ",new{ id },database.Transaction);
        }

        public List<Album> ListarAlbum()
        {
            return database.Connection.Query<Album>(@"
                SELECT   
                     [AlbumId] As Id,
                     [Nome]
                FROM [dbo].[Album]
                ",null,database.Transaction).ToList();
        }

        public Album Obter(int id)
        {
            var album = database.Connection.Query<Album>(@"
                SELECT   
                     [AlbumId] As Id,
                     [Nome]
                FROM [dbo].[Album]
                WHERE [AlbumId]=@Id
                ",new { id },database.Transaction).FirstOrDefault();
            
            var musicaRepository = new MusicaRepository(database);
            var listaDeMusicas = musicaRepository.ListarMusicas(album.Id);

            album.Musicas=listaDeMusicas;

            return album;
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