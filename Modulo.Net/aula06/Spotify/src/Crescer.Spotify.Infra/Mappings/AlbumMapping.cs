using Crescer.Spotify.Dominio.Entidades;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Crescer.Spotify.Infra.Mappings
{
    public class AlbumMapping : IEntityTypeConfiguration<Album>
    {
        public void Configure(EntityTypeBuilder<Album> builder)
        {
            builder.ToTable("Album");

            builder.HasKey(p=>p.Id);

            builder.Property(p=>p.Nome).HasMaxLength(30);

            builder.HasMany(p=>p.Musicas).WithOne();
        }
    }
}