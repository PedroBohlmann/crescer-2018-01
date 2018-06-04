using Crescer.Spotify.Dominio.Entidades;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Crescer.Spotify.Infra.Mappings
{
    public class MusicaMapping : IEntityTypeConfiguration<Musica>
    {
        public void Configure(EntityTypeBuilder<Musica> builder)
        {
            builder.ToTable("Musica");

            builder.HasKey(p=>p.Id);

            builder.Property(p=>p.Nome).HasMaxLength(30);

            builder.Property(p=>p.Duracao);
        }
    }
}