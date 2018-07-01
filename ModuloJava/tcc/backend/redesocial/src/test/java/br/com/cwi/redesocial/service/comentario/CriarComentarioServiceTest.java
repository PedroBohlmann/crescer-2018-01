package br.com.cwi.redesocial.service.comentario;

import br.com.cwi.redesocial.dominio.Comentario;
import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IComentarioRepository;
import br.com.cwi.redesocial.service.usuario.BuscaUsuarioPorEmailService;
import br.com.cwi.redesocial.service.post.BuscarPostPorIdService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CriarComentarioServiceTest {

    @Mock
    private IComentarioRepository comentarioRepository;

    @Mock
    private BuscaUsuarioPorEmailService buscaUsuarioPorEmailService;

    @Mock
    private BuscarPostPorIdService buscarPostPorIdService;

    @InjectMocks
    private CriarComentarioService criarComentarioService;

    @Captor
    private ArgumentCaptor<Comentario> comentarioArgumentCaptor;

    @Test(expected = IllegalArgumentException.class)
    public void testaCriarSemUusuarioCadastrado(){
        criarComentarioService.criar(null,1L,new Comentario());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaCriarSemPostCadastrado(){
        Usuario usuario = new Usuario();
        String email = "pedro@gmail.com";
        usuario.setEmail(email);

        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(usuario);

        criarComentarioService.criar(email,1L,new Comentario());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaCriarPostComComentarioNulo(){
        Usuario usuario = new Usuario();
        String email = "pedro@gmail.com";
        usuario.setEmail(email);

        Long idPost = 1L;
        Post post = new Post();
        post.setId(idPost);

        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(usuario);
        Mockito.when(buscarPostPorIdService.buscar(idPost)).thenReturn(post);

        criarComentarioService.criar(email,1L,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaCriarPostComComentarioComTextoNulo(){
        Usuario usuario = new Usuario();
        String email = "pedro@gmail.com";
        usuario.setEmail(email);

        Long idPost = 1L;
        Post post = new Post();
        post.setId(idPost);

        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(usuario);
        Mockito.when(buscarPostPorIdService.buscar(idPost)).thenReturn(post);

        Comentario comentario = new Comentario();
        comentario.setTexto(null);

        criarComentarioService.criar(email,1L,comentario);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaCriarPostComComentarioComTextoVazio(){
        Usuario usuario = new Usuario();
        String email = "pedro@gmail.com";
        usuario.setEmail(email);

        Long idPost = 1L;
        Post post = new Post();
        post.setId(idPost);

        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(usuario);
        Mockito.when(buscarPostPorIdService.buscar(idPost)).thenReturn(post);

        Comentario comentario = new Comentario();
        comentario.setTexto(null);

        criarComentarioService.criar(email,1L,comentario);
    }

    @Test
    public void testaCriarPostComComentarioComDadosValidos(){
        Usuario usuario = new Usuario();
        String email = "pedro@gmail.com";
        usuario.setEmail(email);

        Long idPost = 1L;
        Post post = new Post();
        post.setId(idPost);

        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(usuario);
        Mockito.when(buscarPostPorIdService.buscar(idPost)).thenReturn(post);

        Comentario comentario = new Comentario();

        comentario.setTexto("Textão");

        criarComentarioService.criar(email,1L,comentario);

        Mockito.verify(comentarioRepository,Mockito.times(1)).save(comentarioArgumentCaptor.capture());

        Comentario comentarioCapturado = comentarioArgumentCaptor.getValue();

        Assert.assertEquals(comentario.getTexto(),comentarioCapturado.getTexto());
        Assert.assertEquals(comentario.getPost(),comentarioCapturado.getPost());
        Assert.assertEquals(comentario.getUsuario(),comentarioCapturado.getUsuario());
    }


}
