package br.com.cwi.redesocial.service.mapeamento;

import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.VisibilidadePost;
import br.com.cwi.redesocial.web.model.request.PostRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MapearPostServiceTest {

    @InjectMocks
    private MapearPostService mapearPostService;

    @Test(expected = IllegalArgumentException.class)
    public void testaMapearRequestParaPostComRequestNulo(){
        mapearPostService.mapearPostRequestParaPost(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaMapearRequestParaPostComTextoNulo(){
        PostRequest request = new PostRequest(null,VisibilidadePost.PUBLICO);
        mapearPostService.mapearPostRequestParaPost(request);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaMapearRequestParaPostComTextoVazio(){
        PostRequest request = new PostRequest("",VisibilidadePost.PUBLICO);
        mapearPostService.mapearPostRequestParaPost(request);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaMapearRequestParaPostComVisibilidadeNula(){
        PostRequest request = new PostRequest("textão",null);
        mapearPostService.mapearPostRequestParaPost(request);
    }

    @Test()
    public void testaMapearRequestParaPostComDadosValidos(){
        PostRequest request = new PostRequest("textão",VisibilidadePost.PUBLICO);
        Post postMapeado = mapearPostService.mapearPostRequestParaPost(request);

        Assert.assertEquals(request.getTexto(),postMapeado.getTexto());
        Assert.assertEquals(request.getVisibilidade(),postMapeado.getVisibilidade());
    }
}
