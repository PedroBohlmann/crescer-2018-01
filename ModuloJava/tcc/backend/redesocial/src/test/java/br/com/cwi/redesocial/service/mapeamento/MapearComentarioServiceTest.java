package br.com.cwi.redesocial.service.mapeamento;

import br.com.cwi.redesocial.dominio.Comentario;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.web.model.request.ComentarioRequest;
import br.com.cwi.redesocial.web.model.response.ComentarioResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MapearComentarioServiceTest {

    @InjectMocks
    private MapearComentarioService mapearComentarioService;

    @Test(expected = IllegalArgumentException.class)
    public void testaMapeamentoRequestParaComentarioComRequestNulo(){
        ComentarioRequest comentarioRequest = null;
        mapearComentarioService.mapearComentarioRequestParaComentario(comentarioRequest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaMapeamentoRequestParaComentarioComIdPostNulo(){
        ComentarioRequest comentarioRequest = new ComentarioRequest();
        comentarioRequest.setIdPost(null);
        mapearComentarioService.mapearComentarioRequestParaComentario(comentarioRequest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaMapeamentoRequestParaComentarioComTextoNulo(){
        ComentarioRequest comentarioRequest = new ComentarioRequest();
        comentarioRequest.setIdPost(1L);
        comentarioRequest.setTexto(null);
        mapearComentarioService.mapearComentarioRequestParaComentario(comentarioRequest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaMapeamentoRequestParaComentarioComTextoVazio(){
        ComentarioRequest comentarioRequest = new ComentarioRequest();
        comentarioRequest.setIdPost(1L);
        comentarioRequest.setTexto("");
        mapearComentarioService.mapearComentarioRequestParaComentario(comentarioRequest);
    }

    @Test
    public void testaMapeamentoRequestParaComentarioComDadosValidos(){
        ComentarioRequest comentarioRequest = new ComentarioRequest();
        comentarioRequest.setIdPost(1L);
        comentarioRequest.setTexto("textão");

        Comentario comentarioMapeado = mapearComentarioService.mapearComentarioRequestParaComentario(comentarioRequest);

        Assert.assertEquals(comentarioRequest.getTexto(),comentarioMapeado.getTexto());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaMapeamentoComentarioParaResponseComComentarioNulo(){
        mapearComentarioService.mapearComentarioParaResponse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaMapeamentoComentarioParaResponseComCriadorDoComentarioNulo(){
        Comentario comentario = new Comentario();
        mapearComentarioService.mapearComentarioParaResponse(comentario);
    }

    @Test
    public void testaMapeamentoComentarioParaResponseComSucesso(){
        Comentario comentario = new Comentario();
        Long id = 1L;
        String texto = "textão";

        comentario.setId(id);
        comentario.setTexto(texto);

        Usuario criador = new Usuario();
        criador.setId(1L);
        criador.setNome("pedro");

        comentario.setUsuario(criador);

        ComentarioResponse response = mapearComentarioService.mapearComentarioParaResponse(comentario);

        Assert.assertEquals(comentario.getId(),response.getId());
        Assert.assertEquals(comentario.getTexto(),response.getTexto());

        Assert.assertEquals(comentario.getUsuario().getId(),response.getIdCriador());
        Assert.assertEquals(comentario.getUsuario().getNome(),response.getNomeCriador());
    }
}
