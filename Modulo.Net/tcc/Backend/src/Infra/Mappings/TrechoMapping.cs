using Dominio.Entidades;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Infra.Mappings
{
    public class TrechoMapping : IEntityTypeConfiguration<Trecho>
    {
        public void Configure(EntityTypeBuilder<Trecho> builder)
        {
            builder.ToTable("Trecho");

            builder.HasKey(p=>p.Id);

            builder.Property(p=>p.DistanciaTotal);

            builder.HasOne(p=>p.Origem).WithOne();

            builder.HasOne(p=>p.Destino).WithOne();
        }
    }
}