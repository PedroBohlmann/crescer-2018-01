using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using PetStore.Dominio.Entidades;

namespace PetStore.Infra.Mappings
{
    public class TagMapping : IEntityTypeConfiguration<Tag>
    {
        public void Configure(EntityTypeBuilder<Tag> builder)
        {
            builder.ToTable("Tag");

            builder.HasKey(p=>p.Id);

            builder.Property(p=>p.Descricao).HasMaxLength(30);
        }
    }
}