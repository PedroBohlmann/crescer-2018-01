package br.com.cwi.redesocial.service.post;

import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.VisibilidadePost;
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
public class BuscarPostPublicoPorIdServiceTest {

    @Mock
    private IPostRepository postRepository;

    @InjectMocks
    private BuscarPostPublicoPorIdService buscarPostPublicoPorIdService;

    @Test(expected = IllegalArgumentException.class)
    public void testaBuscarPostComIdNulo(){
        Long id = null;

        buscarPostPublicoPorIdService.buscar(id);
    }

    @Test
    public void testarBuscarSemUsuarioExistir(){
        Long id = 1L;

        Mockito.when(postRepository.findByIdAndVisibilidade(id,VisibilidadePost.PUBLICO)).thenReturn(Optional.empty());

        Post carregado = buscarPostPublicoPorIdService.buscar(id);

        Assert.assertEquals(null, carregado);
    }

    @Test
    public void testarBuscarComSucesso(){
        Long id = 1L;

        Post post = new Post();

        Mockito.when(postRepository.findByIdAndVisibilidade(id,VisibilidadePost.PUBLICO)).thenReturn(Optional.of(post));

        Post carregado = buscarPostPublicoPorIdService.buscar(id);

        Assert.assertEquals(post, carregado);
    }
}
