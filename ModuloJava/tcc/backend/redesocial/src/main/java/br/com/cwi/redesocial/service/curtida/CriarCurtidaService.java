package br.com.cwi.redesocial.service.curtida;

import br.com.cwi.redesocial.dominio.Curtida;
import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.ICurtidaRepository;
import br.com.cwi.redesocial.service.usuario.BuscaUsuarioPorEmailService;
import br.com.cwi.redesocial.service.post.BuscarPostPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CriarCurtidaService {

    @Autowired
    private ICurtidaRepository curtidaRepository;

    @Autowired
    private BuscarPostPorIdService buscarPostPorIdService;

    @Autowired
    private BuscaUsuarioPorEmailService buscaUsuarioPorEmailService;

    @Autowired
    private BuscarCurtidaPorUsuarioEPostService buscarCurtidaPorUsuarioEPostService;

    @Autowired
    private DeletarCurtidaService deletarCurtidaService;

    public void criar(String email, Long idPost){
        Usuario usuario = buscaUsuarioPorEmailService.buscar(email);

        Post post = buscarPostPorIdService.buscar(idPost);

        if(Objects.isNull(usuario)){
            throw new IllegalArgumentException("Sem usuario com esse email");
        }

        if(Objects.isNull(post)){
            throw new IllegalArgumentException("Sem post com esse id");
        }

        Curtida curtidaExistente = buscarCurtidaPorUsuarioEPostService.buscar(usuario,post);
        if(curtidaExistente==null) {

            Curtida curtida = new Curtida();
            curtida.setPost(post);
            curtida.setUsuario(usuario);

            curtidaRepository.save(curtida);
        }else{
              deletarCurtidaService.deletar(curtidaExistente);
        }
    }
}
