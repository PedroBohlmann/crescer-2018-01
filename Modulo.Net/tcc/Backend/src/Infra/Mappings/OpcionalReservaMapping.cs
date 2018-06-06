using Dominio.Entidades;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Infra.Mappings
{
    public class OpcionalReservaMapping : IEntityTypeConfiguration<OpcionalReserva>
    {
        public void Configure(EntityTypeBuilder<OpcionalReserva> builder)
        {
            builder.ToTable("OpcionalReserva");

            builder.HasKey(p=>p.Id);

            builder.HasOne(p=>p.Reserva).WithMany(x => x.Opcionais).IsRequired();

            builder.HasOne(p=>p.Opcional).WithMany().IsRequired();
        }
    }
}