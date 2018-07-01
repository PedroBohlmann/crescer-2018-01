package br.com.cwi.redesocial.service.post;

import br.com.cwi.redesocial.dominio.Contato;
import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IContatoRepository;
import br.com.cwi.redesocial.service.mapeamento.MapearPostService;
import br.com.cwi.redesocial.service.usuario.BuscarUsuarioPorIdService;
import br.com.cwi.redesocial.web.model.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarPostsService {
    @Autowired
    private IContatoRepository contatoRepository;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    private BuscarPostsPublicosDosAmigosService buscarPostsPublicosDosAmigosService;

    @Autowired
    private MapearPostService mapearPostService;

    public Page<PostResponse> listar(Long id, PageRequest pageRequest){
        Usuario usuario = buscarUsuarioPorIdService.buscar(id);
        List<Contato> contatos = contatoRepository.findByUsuario(usuario);
        List<Usuario> amigos = contatos.stream().map(Contato::getUsuarioConvidado).collect(Collectors.toList());

        List<Post> posts = buscarPostsPublicosDosAmigosService.buscar(amigos);
        posts.addAll(usuario.getPosts());

        List<PostResponse> postResponses = new ArrayList<>();

        for(Post post:posts){
            postResponses.add(mapearPostService.mapearPostParaResponse(post));
        }

        Page<PostResponse> responsePage = new PageImpl<>(postResponses,pageRequest,postResponses.size());

        return responsePage;
    }
}
