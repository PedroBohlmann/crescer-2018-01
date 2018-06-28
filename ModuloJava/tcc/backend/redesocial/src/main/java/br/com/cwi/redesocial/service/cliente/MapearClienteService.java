package br.com.cwi.redesocial.service.cliente;

import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.web.model.request.UsuarioRequest;
import org.springframework.stereotype.Repository;

@Repository
public class MapearClienteService {

    public Usuario mapearUsuarioRequestParaUsuario(UsuarioRequest request){
        Usuario usuario = new Usuario();

        usuario.setId(request.getId());
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setApelido(request.getApelido());
        usuario.setDataDeNascimento(request.getDataDeNascimento());
        usuario.setSenha(request.getSenha());
        usuario.setImagemUrl(request.getImagemUrl());

        return usuario;
    }
}
