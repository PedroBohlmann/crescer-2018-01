package br.com.cwi.redesocial.service.curtida;

import br.com.cwi.redesocial.dominio.Curtida;
import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.ICurtidaRepository;
import br.com.cwi.redesocial.service.usuario.BuscaUsuarioPorEmailService;
import br.com.cwi.redesocial.service.post.BuscarPostPorIdService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CriarCurtidaServiceTest {

    @Mock
    private ICurtidaRepository curtidaRepository;

    @Mock
    private BuscarPostPorIdService buscarPostPorIdService;

    @Mock
    private BuscaUsuarioPorEmailService buscaUsuarioPorEmailService;

    @Mock
    private BuscarCurtidaPorUsuarioEPostService buscarCurtidaPorUsuarioEPostService;

    @Mock
    private DeletarCurtidaService deletarCurtidaService;

    @InjectMocks
    private CriarCurtidaService criarCurtidaService;

    @Captor
    private ArgumentCaptor<Curtida> curtidaArgumentCaptor;

    @Test(expected = IllegalArgumentException.class)
    public void testaCriarCurtidaComUsuarioCadastrado(){
        criarCurtidaService.criar("pedroka@gmail.com",1L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaCriarCurtidaSemPost(){
        String email = "pedroka@gmail.com";
        Usuario usuario = new Usuario();
        usuario.setEmail(email);

        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(usuario);

        criarCurtidaService.criar(email,1L);
    }

    @Test()
    public void testaCriarPostSemCurtidaExistente(){
        String email = "pedroka@gmail.com";
        Usuario usuario = new Usuario();
        usuario.setEmail(email);

        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(usuario);

        Post post = new Post();
        Long idPost = 1L;
        post.setId(idPost);


        Mockito.when(buscarPostPorIdService.buscar(idPost)).thenReturn(post);

        criarCurtidaService.criar(email,idPost);

        Mockito.verify(curtidaRepository,Mockito.times(1)).save(curtidaArgumentCaptor.capture());

        Curtida curtida = curtidaArgumentCaptor.getValue();

        Assert.assertEquals(usuario,curtida.getUsuario());
        Assert.assertEquals(post,curtida.getPost());
    }

    @Test()
    public void testaCriarPostComCurtidaExistente(){
        String email = "pedroka@gmail.com";
        Usuario usuario = new Usuario();
        usuario.setEmail(email);

        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(usuario);

        Post post = new Post();
        Long idPost = 1L;
        post.setId(idPost);

        Mockito.when(buscarPostPorIdService.buscar(idPost)).thenReturn(post);

        Curtida curtida = new Curtida();
        curtida.setUsuario(usuario);
        curtida.setPost(post);
        Mockito.when(buscarCurtidaPorUsuarioEPostService.buscar(usuario,post)).thenReturn(curtida);

        criarCurtidaService.criar(email,idPost);

        Mockito.verify(deletarCurtidaService,Mockito.times(1)).deletar(curtidaArgumentCaptor.capture());

        Curtida curtidaCapturada = curtidaArgumentCaptor.getValue();

        Assert.assertEquals(curtida,curtidaCapturada);
    }
}
