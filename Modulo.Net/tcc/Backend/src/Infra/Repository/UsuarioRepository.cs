using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using Microsoft.EntityFrameworkCore;
using Dominio.Contratos;
using Dominio.Entidades;

namespace Infra.Repository
{
    public class UsuarioRepository : IUsuarioRepository
    {
        private VooContext contexto;

        public UsuarioRepository(VooContext contexto)
        {
            this.contexto = contexto;
        }


        public Usuario ObterUsuarioPorEmailESenha(string Email, string senha)
        {
            var senhaCriptografada = CriptografarSenha(senha);

            return contexto.Usuarios.AsNoTracking()
                .FirstOrDefault(p => p.Email == Email && p.Senha == senhaCriptografada);

        }

        public Usuario ObterUsuarioPorId(int id)
        {
            return contexto.Usuarios.FirstOrDefault(p => p.Id == id);
        }

        public void SalvarUsuario(Usuario usuario)
        {
            usuario.AtualizarSenha(CriptografarSenha(usuario.Senha));
            contexto.Usuarios.Add(usuario);
        }

        private string CriptografarSenha(string senha)
        {
            var inputBytes = Encoding.UTF8.GetBytes(senha);

            var hashedBytes = new SHA256CryptoServiceProvider().ComputeHash(inputBytes);

            return BitConverter.ToString(hashedBytes);
        }
    }
}