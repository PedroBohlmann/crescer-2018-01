package br.com.cwi.redesocial.service.curtida;

import br.com.cwi.redesocial.dominio.Curtida;
import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.ICurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BuscarCurtidaPorUsuarioEPostService {

    @Autowired
    private ICurtidaRepository curtidaRepository;

    public Curtida buscar(Usuario usuario, Post post){

        if(Objects.isNull(usuario)){
            throw new IllegalArgumentException("Usuario nulo");
        }

        if(Objects.isNull(post)){
            throw new IllegalArgumentException("Post nulo");
        }

        return curtidaRepository.findFirstByUsuarioAndPost(usuario,post).orElse(null);
    }

}
