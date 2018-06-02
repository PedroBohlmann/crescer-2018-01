using System;
using System.Collections.Generic;
using System.Linq;
using Crescer.Spotify.Dominio.Contratos;
using Crescer.Spotify.Dominio.Entidades;
using Dapper;
using LojinhaDoCrescer.Infra;

namespace Crescer.Spotify.Infra.Repository
{
    public class MusicaRepository : IMusicaRepository//ARRUMAR ROTAS
    {

        private Database database;

        public MusicaRepository(Database database){
            this.database=database;
        }

        public void AtualizarMusica(int idAlbum, int id, Musica musica)
        {
            database.Connection.Execute(@"
                UPDATE [dbo].[Musica]
                SET [Nome]=@Nome, [Duracao]=@Duracao
                WHERE [MusicaId]=@id AND [AlbumId]=@idAlbum
            ",new {musica.Nome,musica.Duracao,id,idAlbum},database.Transaction);
        }

        public void DeletarMusica(int idAlbum, int id)
        {
            database.Connection.Execute(@"
                DELETE [dbo].[Musica]
                WHERE [MusicaId] = @id and [AlbumId]=@idAlbum   
            ",new {id,idAlbum},database.Transaction);
        }

        public List<Musica> ListarMusicas(int idAlbum)
        {
            return database.Connection.Query<Musica>(@"
                SELECT   
                     [MusicaId] As Id,
                     [Nome],
                     [Duracao]
                FROM [dbo].[Musica]
                WHERE [AlbumId]=@idAlbum
                ",new { idAlbum },database.Transaction).ToList();
        }

        public Musica Obter(int id)
        {
            return database.Connection.Query<Musica>(@"
                SELECT   
                     [MusicaId] As Id,
                     [Nome],
                     [Duracao]
                FROM [dbo].[Musica]
                WHERE [MusicaId]=@Id
                ",new { id },database.Transaction).FirstOrDefault();
           
        }

        public void SalvarMusica(int idAlbum, Musica musica)
        {
            int id = database.Connection.Query<int>(@"
                INSERT INTO [dbo].[Musica]
                    ([Nome],
                    [Duracao],
                    [AlbumId])
                VALUES
                    (@Nome,
                    @Duracao,
                    @idAlbum);
            SELECT CAST(SCOPE_IDENTITY() as int)",new {musica.Nome,musica.Duracao,idAlbum},database.Transaction).Single();
            musica.Id = id;
        }
    }
}