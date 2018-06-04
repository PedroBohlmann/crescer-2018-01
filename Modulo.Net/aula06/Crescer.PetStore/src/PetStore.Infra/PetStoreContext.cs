using JetBrains.Annotations;
using Microsoft.EntityFrameworkCore;
using PetStore.Dominio.Entidades;
using PetStore.Infra.Mappings;

namespace PetStore.Infra
{
    public class PetStoreContext : DbContext
    {
        public PetStoreContext(DbContextOptions options) : base(options)
        {
        }

        public DbSet<Pet> Pets { get; set; }

        public DbSet<Categoria> Categorias { get; set; }

        public DbSet<Tag> Tags { get; set; }

        public DbSet<Usuario> Usuarios { get; set; }

        public DbSet<UsuarioPet> UsuarioPets { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder){
            modelBuilder.ApplyConfiguration(new PetMapping());
            modelBuilder.ApplyConfiguration(new CategoriaMapping());
            modelBuilder.ApplyConfiguration(new TagMapping());
            modelBuilder.ApplyConfiguration(new UsuarioMapping());
            modelBuilder.ApplyConfiguration(new UsuarioPetMapping());
        }
    }
}