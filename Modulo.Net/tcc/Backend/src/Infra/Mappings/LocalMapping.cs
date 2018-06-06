using Dominio.Entidades;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Infra.Mappings
{
    public class LocalMapping : IEntityTypeConfiguration<Local>
    {
        public void Configure(EntityTypeBuilder<Local> builder)
        {
            builder.ToTable("Local");

            builder.HasKey(p=>p.Id);

            builder.Property(p=>p.Cidade).HasMaxLength(50).IsRequired();

            builder.Property(p=>p.Aeroporto).HasMaxLength(50).IsRequired();

            builder.Property(p=>p.Latitude).IsRequired();

            builder.Property(p=>p.Longitude).IsRequired();
        }
    }
}