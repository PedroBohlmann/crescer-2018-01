using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using PetStore.Dominio.Entidades;

namespace PetStore.Infra.Mappings
{
    public class UsuarioMapping : IEntityTypeConfiguration<Usuario>
    {
        public void Configure(EntityTypeBuilder<Usuario> builder)
        {
            builder.ToTable("Usuario");
            
            builder.HasKey(p=>p.Id);
            builder.Property(p => p.Login).HasMaxLength(30);
            builder.Property(p => p.Senha).HasMaxLength(30);
            builder.Property(p => p.PrimeiroNome).HasMaxLength(30);
            builder.Property(p => p.UltimoNome).HasMaxLength(30);
            builder.Property(p => p.Idade).HasMaxLength(30);
            builder.Property(p => p.Email).HasMaxLength(30);
            builder.Property(p => p.Telefone).HasMaxLength(30);
            builder.Property(p => p.Status);

        }
    }
}