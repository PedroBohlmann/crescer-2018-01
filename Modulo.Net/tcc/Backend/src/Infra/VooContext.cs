using System;
using Dominio.Entidades;
using Infra.Mappings;
using JetBrains.Annotations;
using Microsoft.EntityFrameworkCore;

namespace Infra
{
    public class VooContext : DbContext
    {
        public VooContext(DbContextOptions options) : base(options) { }

        public DbSet<Local> Locais { get; set; }

        public DbSet<Trecho> Trechos { get; set; }

        public DbSet<ClasseDeVoo> ClassesDeVoo { get; set; }

        public DbSet<Opcional> Opcional { get; set; }

        public DbSet<Reserva> Reservas { get; set; }

        public DbSet<Usuario> Usuarios { get; set; }

        public DbSet<OpcionalReserva> OpcionalReservas { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.ApplyConfiguration(new LocalMapping());
            modelBuilder.ApplyConfiguration(new TrechoMapping());
            modelBuilder.ApplyConfiguration(new ClasseDeVooMapping());
            modelBuilder.ApplyConfiguration(new OpcionalMapping());
            modelBuilder.ApplyConfiguration(new ReservaMapping());
            modelBuilder.ApplyConfiguration(new OpcionalReservaMapping());
            modelBuilder.ApplyConfiguration(new UsuarioMapping());
        }

    }
}
