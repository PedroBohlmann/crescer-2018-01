package br.com.cwi.redesocial.service.mapeamento;

import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.web.model.request.UsuarioRequest;
import br.com.cwi.redesocial.web.model.response.PostResponse;
import br.com.cwi.redesocial.web.model.response.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MapearUsuarioService {

    @Autowired
    private MapearPostService mapearPostService;

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

    public UsuarioResponse mapearUsuarioParaUsuarioResponse(Usuario usuario){
        if(Objects.isNull(usuario)){
            throw new IllegalArgumentException("Sem usuario");
        }
        UsuarioResponse response = new UsuarioResponse();
        response.setId(usuario.getId());
        response.setNome(usuario.getNome());
        response.setEmail(usuario.getEmail());
        response.setApelido(usuario.getApelido());
        response.setDataDeNascimento(usuario.getDataDeNascimento());
        response.setImagemUrl(usuario.getImagemUrl());

        return response;
    }
}
