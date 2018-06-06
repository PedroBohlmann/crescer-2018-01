using Dominio.Entidades;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Infra.Mappings
{
    public class ClasseDeVooMapping : IEntityTypeConfiguration<ClasseDeVoo>
    {
        public void Configure(EntityTypeBuilder<ClasseDeVoo> builder)
        {
            builder.ToTable("ClasseDeVoo");

            builder.HasKey(p=>p.Id);

            builder.Property(p=>p.Descricao).HasMaxLength(50).IsRequired();

            builder.Property(p=>p.ValorFixo).IsRequired();

            builder.Property(p=>p.ValorMilha).IsRequired();
        }
    }
}