package br.com.cwi.redesocial.service.post;

import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.VisibilidadePost;
import br.com.cwi.redesocial.dominio.repository.IPostRepository;
import br.com.cwi.redesocial.service.cliente.BuscaUsuarioPorEmailService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CriarNovoPostServiceTest {
    @Mock
    private IPostRepository repository;

    @Mock
    private BuscaUsuarioPorEmailService buscaUsuarioPorEmailService;

    @InjectMocks
    private CriarNovoPostService criarNovoPostService;

    @Captor
    private ArgumentCaptor<Post> captadorDePost;

    @Test(expected = IllegalArgumentException.class)
    public void testaCriarPostSemUsuarioExistente(){
        String email = "pedro@gmail.com";
        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(null);

        criarNovoPostService.criar(email,new Post());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaCriarPostComTextoNulo(){
        Usuario usuario = new Usuario();
        String email = "pedro@gmail.com";
        usuario.setEmail(email);
        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(usuario);

        Post post = new Post();
        post.setTexto(null);

        criarNovoPostService.criar(email,post);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaCriarPostComTextoVazio(){
        Usuario usuario = new Usuario();
        String email = "pedro@gmail.com";
        usuario.setEmail(email);
        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(usuario);

        Post post = new Post();
        post.setTexto("");

        criarNovoPostService.criar(email,post);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaCriarPostComVisibilidadeNula(){
        Usuario usuario = new Usuario();
        String email = "pedro@gmail.com";
        usuario.setEmail(email);
        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(usuario);

        Post post = new Post();
        post.setTexto("textão");
        post.setVisibilidade(null);

        criarNovoPostService.criar(email,post);
    }

    @Test()
    public void testaCriarPostValido(){
        Usuario usuario = new Usuario();
        String email = "pedro@gmail.com";
        usuario.setEmail(email);
        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(usuario);

        Post post = new Post();
        post.setTexto("textão");
        post.setVisibilidade(VisibilidadePost.PUBLICO);

        criarNovoPostService.criar(email,post);

        Mockito.verify(repository,Mockito.times(1)).save(captadorDePost.capture());

        Post postCapturado = captadorDePost.getValue();

        Assert.assertEquals("textão",postCapturado.getTexto());
        Assert.assertEquals(usuario,postCapturado.getCriador());
        Assert.assertEquals(VisibilidadePost.PUBLICO,postCapturado.getVisibilidade());
    }
}
