using System.Collections.Generic;
using System.Linq;
using Crescer.Spotify.Dominio.Contratos;
using Crescer.Spotify.Dominio.Entidades;
using Dapper;
using LojinhaDoCrescer.Infra;

namespace Crescer.Spotify.Infra.Repository
{
    public class UsuarioRepository : IUsuarioRepository
    {
        private Database database;

        public UsuarioRepository(Database database)
        {
            this.database = database;
        }
        public void AtualizarUsuario(int id, Usuario usuario)
        {
            database.Connection.Execute(@"
                UPDATE [dbo].[Usuario]
                SET [Nome]=@Nome
                WHERE [UsuarioId]=@Id
            ",new {usuario.Nome,id},database.Transaction);
        }

        public void DeletarUsuario(int id)
        {
            database.Connection.Execute(@"
                DELETE [dbo].[Usuario]
                WHERE [UsuarioId]=@Id
            ",new { id },database.Transaction);
        }

        public List<Usuario> ListarUsuarios()
        {
            return database.Connection.Query<Usuario>(@"
                SELECT 
                    [UsuarioId] As Id,
                    [Nome]
                FROM [dbo].[Usuario]
            ", null, database.Transaction).ToList();
        }

        public Usuario Obter(int id)
        {
            var usuario = database.Connection.Query<Usuario>(@"
                SELECT 
                    [UsuarioId] As Id,
                    [Nome]
                FROM [dbo].[Usuario]
                WHERE [UsuarioId]=@Id
            ", new { id }, database.Transaction).FirstOrDefault();

            return usuario;
        }

        public void SalvarUsuario(Usuario usuario)
        {
            int id = database.Connection.Query<int>(@"
                INSERT INTO [dbo].[Usuario]
                    ([Nome])
                VALUES(@Nome);
                SELECT CAST(SCOPE_IDENTITY() as int);
            ", new { usuario.Nome }, database.Transaction).Single();

            usuario.Id = id;
        }
    }
}