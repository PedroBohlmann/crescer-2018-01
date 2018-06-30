package br.com.cwi.redesocial.service.curtida;

import br.com.cwi.redesocial.dominio.Curtida;
import br.com.cwi.redesocial.dominio.repository.ICurtidaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DeletarCurtidaServiceTest {

    @Mock
    private ICurtidaRepository curtidaRepository;

    @Captor
    private ArgumentCaptor<Curtida> curtidaArgumentCaptor;

    @InjectMocks
    private DeletarCurtidaService deletarCurtidaService;

    @Test(expected = IllegalArgumentException.class)
    public void testaDeletarComCurtidaNula(){
        deletarCurtidaService.deletar(null);
    }

    @Test
    public void testaDeletarComSucesso(){
        Curtida curtida = new Curtida();

        deletarCurtidaService.deletar(curtida);

        Mockito.verify(curtidaRepository,Mockito.times(1)).delete(curtidaArgumentCaptor.capture());

        Curtida curtidaCapturada = curtidaArgumentCaptor.getValue();

        Assert.assertEquals(curtida,curtidaCapturada);
    }
}