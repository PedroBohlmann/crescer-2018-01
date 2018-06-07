using Dominio.Entidades;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Infra.Mappings
{
    public class ReservaMapping : IEntityTypeConfiguration<Reserva>
    {
        public void Configure(EntityTypeBuilder<Reserva> builder)
        {
            builder.ToTable("Reserva");

            builder.HasKey(p=>p.Id);

            builder.HasOne(p=>p.ClasseDeVoo).WithMany().IsRequired();

            builder.HasOne(p=>p.Trecho).WithMany().IsRequired();//.OnDelete(DeleteBehavior.Restrict);

            builder.HasMany(p=>p.Opcionais).WithOne().IsRequired();

            builder.Property(p=>p.ValorTotal).IsRequired();

            builder.HasOne(p=>p.Usuario).WithMany().IsRequired();
        }
    }
}