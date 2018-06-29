package br.com.cwi.redesocial.service.mapeamento;

import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.web.model.request.UsuarioRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MapearUsuarioService {

    public Usuario mapearUsuarioRequestParaUsuario(UsuarioRequest request){

        if(Objects.isNull(request)){
            throw new IllegalArgumentException("Request nulo");
        }

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
