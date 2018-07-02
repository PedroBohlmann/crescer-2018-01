package br.com.cwi.redesocial.service.post;

import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.VisibilidadePost;
import br.com.cwi.redesocial.dominio.repository.IPostRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class AtualizarVisibilidadePostServiceTest {

    @Mock
    private IPostRepository postRepository;

    @Mock
    private BuscarPostPorIdService buscarPostPorIdService;

    @InjectMocks
    private AtualizarVisibilidadePostService atualizarVisibilidadePostService;

    @Captor
    public ArgumentCaptor<Post> argumentCaptor;

    @Test(expected = IllegalArgumentException.class)
    public void testarAtualizarComIdNulo(){
        atualizarVisibilidadePostService.atualizar(null,VisibilidadePost.PUBLICO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testarAtualizarComVisibilidadeNula(){
        atualizarVisibilidadePostService.atualizar(1L,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testarAtualizarSemPostComEsseId(){
        Long id = 1L;
        Mockito.when(buscarPostPorIdService.buscar(id)).thenReturn(null);

        atualizarVisibilidadePostService.atualizar(id,VisibilidadePost.PUBLICO);
    }

    @Test
    public void testarAtualizarComSucesso(){
        Post post = new Post();
        post.setVisibilidade(VisibilidadePost.PRIVADO);
        Long idPost = 1L;
        post.setId(idPost);

        Mockito.when(buscarPostPorIdService.buscar(idPost)).thenReturn(post);

        atualizarVisibilidadePostService.atualizar(idPost,VisibilidadePost.PRIVADO);

        Mockito.verify(postRepository,Mockito.times(1)).save(argumentCaptor.capture());

        Post capturado = argumentCaptor.getValue();

        Assert.assertEquals(post,capturado);
    }

}