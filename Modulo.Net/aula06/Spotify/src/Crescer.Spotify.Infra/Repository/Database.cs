using System;
using System.Data.SqlClient;

namespace LojinhaDoCrescer.Infra
{
    public class Database  : IDisposable
    {
        public SqlConnection Connection { get; private set; }
        public SqlTransaction Transaction { get; private set; }
        public Database(string connectionString)
        {
            this.Connection = new SqlConnection(connectionString);
            this.Connection.Open();
            this.Transaction = this.Connection.BeginTransaction();
        }

        public void Commit()
        {
            this.Transaction.Commit();
        }

        public void Rollback()
        {
            this.Transaction.Rollback();
        }

        public void Dispose()
        {
            this.Connection.Dispose();
        }
    }  
}