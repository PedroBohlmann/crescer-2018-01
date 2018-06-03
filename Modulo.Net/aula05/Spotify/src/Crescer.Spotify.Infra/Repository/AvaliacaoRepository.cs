using System.Collections.Generic;
using System.Linq;
using Crescer.Spotify.Dominio.Contratos;
using Crescer.Spotify.Dominio.Entidades;
using Dapper;
using LojinhaDoCrescer.Infra;

namespace Crescer.Spotify.Infra.Repository
{
    public class AvaliacaoRepository : IAvaliacaoRepository
    {
        private Database database;
        public AvaliacaoRepository(Database database)
        {
            this.database = database;
        }

        public void AtualizarAvaliacao(Avaliacao avaliacao)
        {
            database.Connection.Execute(@"
                UPDATE [dbo].[Avaliacao]
                SET [Nota]=@Nota
                WHERE [MusicaId]=@IdMusica AND [UsuarioId]=@IdUsuario
            ", new { avaliacao.Nota, avaliacao.IdMusica, avaliacao.IdUsuario }, database.Transaction);
        }

        public double AvaliacaoAlbum(int idAlbum)
        {
            var media = database.Connection.Query<double>(@"
                Select AVG(t.Media) 
                from(
                    Select m.MusicaId, AVG(A.Nota) as Media
                    from Musica m
                    inner join Avaliacao A on m.MusicaId=A.MusicaId
                    where m.AlbumId=@idAlbum
                    group by m.MusicaId
                    )t
            ",new {idAlbum},database.Transaction).FirstOrDefault();
            return media;
        }

        public double MediaAvaliacoes(int idMusica)
        {
            var media = database.Connection.Query<double>(@"
                SELECT AVG(Nota) 
                FROM [dbo].[Avaliacao]
                WHERE [MusicaId]=@IdMusica
            ", new { idMusica }, database.Transaction).FirstOrDefault();
            return media;
        }

        public void SalvarAvaliacao(Avaliacao avaliacao)
        {
            if (VerificaSeExisteAlgumaAvaliacao(avaliacao))
            {
                AtualizarAvaliacao(avaliacao);
            }
            else
            {
                int id = database.Connection.Query<int>(@"
                INSERT INTO [dbo].[Avaliacao]
                    ([MusicaId],
                    [UsuarioId],
                    [Nota])
                VALUES
                    (@IdMusica,
                    @IdUsuario,
                    @Nota);
                SELECT CAST(SCOPE_IDENTITY() as int)", new { avaliacao.IdMusica, avaliacao.IdUsuario, avaliacao.Nota }, database.Transaction).Single();
                avaliacao.Id = id;
            }

        }

        public bool VerificaSeExisteAlgumaAvaliacao(Avaliacao avaliacao)
        {
            int id = database.Connection.Query<int>(@"
                SELECT [MusicaId]
                FROM [dbo].[Avaliacao]
                WHERE [UsuarioId]=@IdUsuario AND [MusicaId]=@IdMusica
            ", new { avaliacao.IdUsuario, avaliacao.IdMusica }, database.Transaction).FirstOrDefault();
            return id > 0;
        }
    }
}