using System.Collections.Generic;
using System.Linq;
using Crescer.Spotify.Dominio.Contratos;
using Crescer.Spotify.Dominio.Entidades;
using Dapper;
using LojinhaDoCrescer.Infra;
using Microsoft.EntityFrameworkCore;

namespace Crescer.Spotify.Infra.Repository
{
    public class UsuarioRepository : IUsuarioRepository
    {
        private SpotifyContext contexto;

        public UsuarioRepository(SpotifyContext contexto)
        {
            this.contexto = contexto;
        }
        public void AtualizarUsuario(int id, Usuario usuario)
        {
            var usuarioCadastrado = contexto.Usuarios.FirstOrDefault(p => p.Id == id);
            usuarioCadastrado.AtualizarUsuario(usuario);
        }

        public void DeletarUsuario(int id)
        {
            var usuarioCadastrado = contexto.Usuarios.FirstOrDefault(p => p.Id == id);
            contexto.Remove(usuarioCadastrado);
        }

        public List<Usuario> ListarUsuarios()
        {
            return contexto.Usuarios.ToList();
        }

        public Usuario Obter(int id)
        {
            return contexto.Usuarios.FirstOrDefault(p => p.Id == id);
        }

        public void SalvarUsuario(Usuario usuario)
        {
            contexto.Usuarios.Add(usuario);
        }
    }
}