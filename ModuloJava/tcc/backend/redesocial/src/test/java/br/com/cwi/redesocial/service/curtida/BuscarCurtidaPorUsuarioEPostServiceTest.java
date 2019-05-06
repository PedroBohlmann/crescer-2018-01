package br.com.cwi.redesocial.service.curtida;

import br.com.cwi.redesocial.dominio.Curtida;
import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.ICurtidaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarCurtidaPorUsuarioEPostServiceTest {

    @Mock
    private ICurtidaRepository curtidaRepository;

    @InjectMocks
    private BuscarCurtidaPorUsuarioEPostService buscarCurtidaPorUsuarioEPostService;

    @Test(expected = IllegalArgumentException.class)
    public void testaBuscarComUsuarioNulo(){
        buscarCurtidaPorUsuarioEPostService.buscar(null,new Post());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaBuscarComPostNulo(){
        buscarCurtidaPorUsuarioEPostService.buscar(new Usuario(),null);
    }

    @Test
    public void testaBuscarValidoMasSemExistirNoBanco(){
        Optional<Curtida> optionalCurtida = Optional.empty();
        Post post = new Post();
        Usuario usuario = new Usuario();

        Mockito.when(curtidaRepository.findFirstByUsuarioAndPost(usuario,post)).thenReturn(optionalCurtida);

        Curtida curtida = buscarCurtidaPorUsuarioEPostService.buscar(usuario,post);

        Assert.assertNull(curtida);
    }

    @Test
    public void testaBuscarValidoMasExistindoNoBanco(){
        Curtida curtida = new Curtida();
        Optional<Curtida> optionalCurtida = Optional.of(curtida);

        Post post = new Post();
        Usuario usuario = new Usuario();

        Mockito.when(curtidaRepository.findFirstByUsuarioAndPost(usuario,post)).thenReturn(optionalCurtida);

        Curtida curtidaBuscada = buscarCurtidaPorUsuarioEPostService.buscar(usuario,post);

        Assert.assertEquals(curtida,curtidaBuscada);
    }

}
