package br.com.cwi.redesocial.service.post;

import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.repository.IPostRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarPostPorIdServiceTest {

    @Mock
    private IPostRepository postRepository;

    @InjectMocks
    private BuscarPostPorIdService buscarPostPorIdService;

    @Test(expected = IllegalArgumentException.class)
    public void testaBuscarPostComIdNulo(){
        buscarPostPorIdService.buscar(null);
    }

    @Test
    public void testaBuscarPostComIdValidoEPostNaoExistente(){

        Optional<Post> opcional = Optional.empty();

        Mockito.when(postRepository.findById(1L)).thenReturn(opcional);

        Post postCarregado = buscarPostPorIdService.buscar(1L);

        Assert.assertNull(postCarregado);
    }

    @Test
    public void testaBuscarPostComIdValidoEPostExistente(){
        Post post = new Post();
        Optional<Post> opcional = Optional.of(post);

        Mockito.when(postRepository.findById(1L)).thenReturn(opcional);

        Post postCarregado = buscarPostPorIdService.buscar(1L);

        Assert.assertEquals(post,postCarregado);
    }
}
