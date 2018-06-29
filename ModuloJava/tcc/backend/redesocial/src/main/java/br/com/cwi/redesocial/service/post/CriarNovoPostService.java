package br.com.cwi.redesocial.service.post;

import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IPostRepository;
import br.com.cwi.redesocial.service.cliente.BuscaUsuarioPorEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CriarNovoPostService {

    @Autowired
    private IPostRepository repository;

    @Autowired
    private BuscaUsuarioPorEmailService buscaUsuarioPorEmailService;

    public void criar(String email, Post post){
        Usuario usuarioCarregado = buscaUsuarioPorEmailService.buscar(email);

        if(Objects.isNull(usuarioCarregado)){
            throw new IllegalArgumentException("Sem Usuario com esse email");
        }
        if(Objects.isNull(post.getTexto())|| post.getTexto().length()==0){
            throw new IllegalArgumentException("Texto da post está nulo ou vazio");
        }
        if(Objects.isNull(post.getVisibilidade())){
            throw new IllegalArgumentException("Visibilidade invalida");
        }

        post.setCriador(usuarioCarregado);

        repository.save(post);
    }
}
