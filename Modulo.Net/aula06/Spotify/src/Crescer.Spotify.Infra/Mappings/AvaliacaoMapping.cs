using Crescer.Spotify.Dominio.Entidades;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Crescer.Spotify.Infra.Mappings
{
    public class AvaliacaoMapping : IEntityTypeConfiguration<Avaliacao>
    {
        public void Configure(EntityTypeBuilder<Avaliacao> builder)
        {
            builder.ToTable("Avalicao");

            builder.HasKey(p=>p.Id);
            
            builder.HasOne(p=>p.Usuario).WithMany();

            builder.HasOne(p=>p.Musica).WithMany();

            builder.Property(p=>p.Nota).IsRequired();
        }
    }
}