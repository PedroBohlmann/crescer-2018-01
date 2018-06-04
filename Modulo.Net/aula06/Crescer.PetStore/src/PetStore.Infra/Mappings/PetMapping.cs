using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using PetStore.Dominio.Entidades;

namespace PetStore.Infra.Mappings
{
    public class PetMapping : IEntityTypeConfiguration<Pet>
    {
        public void Configure(EntityTypeBuilder<Pet> builder)
        {
            builder.ToTable("Pet");

            builder.HasKey(p=>p.Id);

            builder.Property(p => p.Nome).HasMaxLength(20);
            builder.HasMany(p => p.Tags).WithOne();
            builder.HasOne(p => p.Categoria).WithMany();
            builder.Property(p=>p.Status);
        }
    }
}