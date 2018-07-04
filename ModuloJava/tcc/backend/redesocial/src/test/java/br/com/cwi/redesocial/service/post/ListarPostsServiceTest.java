package br.com.cwi.redesocial.service.post;

import br.com.cwi.redesocial.dominio.Contato;
import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IContatoRepository;
import br.com.cwi.redesocial.service.mapeamento.MapearPostService;
import br.com.cwi.redesocial.service.usuario.BuscarUsuarioPorIdService;
import br.com.cwi.redesocial.web.model.response.PostResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ListarPostsServiceTest {

    @Mock
    private IContatoRepository contatoRepository;

    @Mock
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Mock
    private BuscarPostsPublicosDosAmigosService buscarPostsPublicosDosAmigosService;

    @Mock
    private MapearPostService mapearPostService;

    @InjectMocks
    private ListarPostsService listarPostsService;

    @Test(expected = IllegalArgumentException.class)
    public void testarListarComIdNulo(){
        listarPostsService.listar(null,new PageRequest(1,10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testarListarComPageNulo(){
        listarPostsService.listar(1L,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testarListarSemUsuarioCadastrado(){
        Usuario usuario = new Usuario();
        Long idUsuario = 1L;
        usuario.setId(idUsuario);
        usuario.setPosts(new ArrayList<>());

        Usuario usuarioAmigo = new Usuario();

        List<Usuario> amigos = new ArrayList<>();
        amigos.add(usuarioAmigo);

        Contato contato = new Contato();
        contato.setUsuario(usuario);
        contato.setUsuarioConvidado(usuarioAmigo);

        List<Contato> contatos = new ArrayList<>();
        contatos.add(contato);

        Mockito.when(contatoRepository.findByUsuario(usuario)).thenReturn(contatos);

        List<Post> posts = new ArrayList<>();
        Post post = new Post();
        posts.add(post);

        Mockito.when(buscarPostsPublicosDosAmigosService.buscar(amigos)).thenReturn(posts);

        PostResponse postResponse = new PostResponse();

        Mockito.when(mapearPostService.mapearPostParaResponse(post)).thenReturn(postResponse);

        Page<PostResponse> response = listarPostsService.listar(idUsuario,new PageRequest(1,10));

        List<PostResponse> responseList = response.getContent();

        Assert.assertEquals(postResponse, responseList.get(0));
    }

    @Test
    public void testarListarComUsuarioCadastrado(){
        Usuario usuario = new Usuario();
        Long idUsuario = 1L;
        usuario.setId(idUsuario);
        usuario.setPosts(new ArrayList<>());

        Usuario usuarioAmigo = new Usuario();

        List<Usuario> amigos = new ArrayList<>();
        amigos.add(usuarioAmigo);

        Contato contato = new Contato();
        contato.setUsuario(usuario);
        contato.setUsuarioConvidado(usuarioAmigo);

        List<Contato> contatos = new ArrayList<>();
        contatos.add(contato);

        Mockito.when(contatoRepository.findByUsuario(usuario)).thenReturn(contatos);

        Mockito.when(buscarUsuarioPorIdService.buscar(idUsuario)).thenReturn(usuario);

        List<Post> posts = new ArrayList<>();
        Post post = new Post();
        posts.add(post);

        Mockito.when(buscarPostsPublicosDosAmigosService.buscar(amigos)).thenReturn(posts);

        PostResponse postResponse = new PostResponse();

        Mockito.when(mapearPostService.mapearPostParaResponse(post)).thenReturn(postResponse);

        Page<PostResponse> response = listarPostsService.listar(idUsuario,new PageRequest(1,10));

        List<PostResponse> responseList = response.getContent();

        Assert.assertEquals(postResponse, responseList.get(0));
    }
}
