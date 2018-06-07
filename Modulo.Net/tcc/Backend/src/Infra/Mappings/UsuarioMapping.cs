using Dominio.Entidades;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Infra.Mappings
{
    public class UsuarioMapping : IEntityTypeConfiguration<Usuario>
    {
        public void Configure(EntityTypeBuilder<Usuario> builder)
        {
            builder.ToTable("Usuario");

            builder.HasKey(p => p.Id);

            builder.Property(p => p.PrimeiroNome).HasMaxLength(50).IsRequired();

            builder.Property(p => p.UltimoNome).HasMaxLength(50).IsRequired();

            builder.Property(p => p.Cpf).HasMaxLength(11).IsRequired();

            builder.Property(p => p.DataNascimento).IsRequired();

            builder.Property(p => p.Senha).IsRequired();

            builder.Property(p => p.Email).HasMaxLength(50).IsRequired();

            builder.Property(p=>p.Admin).IsRequired();
        }
    }
}