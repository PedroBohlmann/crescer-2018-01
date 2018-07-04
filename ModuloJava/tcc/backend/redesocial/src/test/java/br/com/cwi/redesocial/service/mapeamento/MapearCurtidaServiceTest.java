package br.com.cwi.redesocial.service.mapeamento;

import br.com.cwi.redesocial.dominio.Curtida;
import br.com.cwi.redesocial.web.model.response.CurtidaResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MapearCurtidaServiceTest {

    @InjectMocks
    private MapearCurtidaService mapearCurtidaService;

    @Captor
    private ArgumentCaptor<Curtida> argumentCaptor;

    @Test(expected = IllegalArgumentException.class)
    public void testaMapearCurtidaParaResponseComCurtidaNula(){
        mapearCurtidaService.mapearCurtidaParaResponse(null);
    }

    @Test
    public void testarMapearCurtidaComSucesso(){
        Curtida curtida = new Curtida();
        Long id = 1L;
        curtida.setId(id);

        CurtidaResponse response = mapearCurtidaService.mapearCurtidaParaResponse(curtida);

        Assert.assertEquals(response.getIdCurtida(),id);
    }
}
