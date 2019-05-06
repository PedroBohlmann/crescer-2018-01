package br.com.cwi.redesocial.service.post;

import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.VisibilidadePost;
import br.com.cwi.redesocial.dominio.repository.IPostRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarPostsPublicosDosAmigosServiceTest {

    @Mock
    private IPostRepository postRepository;

    @InjectMocks
    private BuscarPostsPublicosDosAmigosService buscarPostsPublicosDosAmigosService;

    @Test(expected = IllegalArgumentException.class)
    public void testaBuscarPostComListaDeAmigosNull(){
        buscarPostsPublicosDosAmigosService.buscar(null);
    }

    @Test
    public void testaBuscarPostsComAmigos(){
        List<Post> posts = new ArrayList<>();
        List<Usuario> amigos = new ArrayList<>();
        Mockito.when(postRepository.findByCriadorInAndVisibilidade(amigos,VisibilidadePost.PUBLICO)).thenReturn(posts);

        List<Post> postsCarregados = buscarPostsPublicosDosAmigosService.buscar(amigos);

        Assert.assertEquals(posts,postsCarregados);
    }
}
