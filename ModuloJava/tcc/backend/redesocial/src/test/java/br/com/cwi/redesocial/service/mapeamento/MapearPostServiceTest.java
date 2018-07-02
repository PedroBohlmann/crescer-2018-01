package br.com.cwi.redesocial.service.mapeamento;

import br.com.cwi.redesocial.dominio.*;
import br.com.cwi.redesocial.web.model.request.PostRequest;
import br.com.cwi.redesocial.web.model.response.ComentarioResponse;
import br.com.cwi.redesocial.web.model.response.CurtidaResponse;
import br.com.cwi.redesocial.web.model.response.PostResponse;
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
public class MapearPostServiceTest {

    @Mock
    private MapearCurtidaService mapearCurtidaService;

    @Mock
    private MapearComentarioService mapearComentarioService;

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

    // Response

    @Test(expected = IllegalArgumentException.class)
    public void testaMapearPostParaResponseComPostNulo(){
        mapearPostService.mapearPostParaResponse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaMapearPostParaResponseComUsuarioCriadorNulo(){
        Post post = new Post();
        post.setId(1L);
        post.setTexto("texto");

        mapearPostService.mapearPostParaResponse(post);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaMapearPostParaResponseComPostComCurtidasNula(){
        Post post = new Post();
        post.setId(1L);
        post.setTexto("texto");

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Pedroka");

        post.setCriador(usuario);

        mapearPostService.mapearPostParaResponse(post);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaMapearPostParaResponseComPostComComentarioNula(){
        Post post = new Post();
        post.setId(1L);
        post.setTexto("texto");

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Pedroka");

        post.setCurtidas(new ArrayList<>());

        post.setCriador(usuario);

        mapearPostService.mapearPostParaResponse(post);
    }

    @Test
    public void testaMapearPostParaResponseComPostComDadosValidos(){
        Post post = new Post();
        post.setId(1L);
        post.setTexto("texto");

        Comentario comentario = new Comentario();
        List<Comentario> comentarios = new ArrayList<>();
        comentarios.add(comentario);

        post.setComentarios(comentarios);

        Curtida curtida = new Curtida();
        curtida.setPost(post);
        List<Curtida> curtidas = new ArrayList<>();
        curtidas.add(curtida);

        post.setCurtidas(curtidas);

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Pedroka");

        curtida.setUsuario(usuario);
        comentario.setUsuario(usuario);

        post.setCriador(usuario);

        ComentarioResponse comentarioResponse = new ComentarioResponse();
        comentarioResponse.setTexto(comentario.getTexto());
        comentarioResponse.setNomeCriador(usuario.getNome());
        comentarioResponse.setIdCriador(usuario.getId());

        CurtidaResponse curtidaResponse = new CurtidaResponse();
        curtidaResponse.setIdCurtida(curtida.getId());

        Mockito.when(mapearComentarioService.mapearComentarioParaResponse(comentario)).thenReturn(comentarioResponse);
        Mockito.when(mapearCurtidaService.mapearCurtidaParaResponse(curtida)).thenReturn(curtidaResponse);

        PostResponse response = mapearPostService.mapearPostParaResponse(post);

        Assert.assertEquals(post.getTexto(),response.getTexto());
        Assert.assertEquals(post.getCriador().getNome(),response.getNomeCriador());
        Assert.assertEquals(curtidaResponse,response.getCurtidas().get(0));
        Assert.assertEquals(comentarioResponse,response.getComentarios().get(0));
    }

}
