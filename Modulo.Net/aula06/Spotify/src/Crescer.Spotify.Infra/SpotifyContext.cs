using Crescer.Spotify.Dominio.Entidades;
using Crescer.Spotify.Infra.Mappings;
using JetBrains.Annotations;
using Microsoft.EntityFrameworkCore;

namespace Crescer.Spotify.Infra
{
    public class SpotifyContext : DbContext
    {
        public SpotifyContext(DbContextOptions options) : base(options)
        {}

        public DbSet<Usuario> Usuarios{get;set;}

        public DbSet<Album> Albuns{get;set;}

        public DbSet<Musica> Musicas{get;set;}

        public DbSet<Avaliacao> Avaliacoes{get;set;}

        protected override void OnModelCreating(ModelBuilder modelBuilder){
            modelBuilder.ApplyConfiguration(new UsuarioMapping());
            modelBuilder.ApplyConfiguration(new AlbumMapping());
            modelBuilder.ApplyConfiguration(new MusicaMapping());
            modelBuilder.ApplyConfiguration(new AvaliacaoMapping());
        }
    }
}