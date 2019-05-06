package br.com.cwi.redesocial.service.contato;

import br.com.cwi.redesocial.dominio.Contato;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IContatoRepository;
import br.com.cwi.redesocial.service.usuario.BuscarUsuarioPorIdService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DeletarAmizadeServiceTest {

    @Mock
    private IContatoRepository contatoRepository;

    @Mock
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @InjectMocks
    private DeletarAmizadeService deletarAmizadeService;

    @Captor
    private ArgumentCaptor<Contato> contatoArgumentCaptor;


    @Test(expected = IllegalArgumentException.class)
    public void testaExcluirAmizadeSemUsuarioCriador(){
        Long idCriador = 1L;
        Usuario usuarioCriador = null;

        Mockito.when(buscarUsuarioPorIdService.buscar(idCriador)).thenReturn(usuarioCriador);

        deletarAmizadeService.deletar(idCriador,2L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testarExcluirAmizadeSemUsuarioConvidado(){
        Long idCriador = 1L;
        Usuario usuarioCriador = new Usuario();

        Mockito.when(buscarUsuarioPorIdService.buscar(idCriador)).thenReturn(usuarioCriador);

        deletarAmizadeService.deletar(idCriador,2L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testarExcluirAmizadeSemContato(){
        Long idCriador = 1L;
        Usuario usuarioCriador = new Usuario();

        Long idConvidado = 2L;
        Usuario usuarioConvidado = new Usuario();

        Mockito.when(buscarUsuarioPorIdService.buscar(idCriador)).thenReturn(usuarioCriador);
        Mockito.when(buscarUsuarioPorIdService.buscar(idConvidado)).thenReturn(usuarioConvidado);

        deletarAmizadeService.deletar(idCriador,idConvidado);
    }

    @Test
    public void testarExcluirAmizadeComSucesso(){
        Long idCriador = 1L;
        Usuario usuarioCriador = new Usuario();

        Long idConvidado = 2L;
        Usuario usuarioConvidado = new Usuario();

        Mockito.when(buscarUsuarioPorIdService.buscar(idCriador)).thenReturn(usuarioCriador);
        Mockito.when(buscarUsuarioPorIdService.buscar(idConvidado)).thenReturn(usuarioConvidado);

        Contato contatoCriador = new Contato();
        Contato contatoConvidado = new Contato();

        Mockito.when(contatoRepository.findByUsuarioAndUsuarioConvidado(usuarioCriador,usuarioConvidado)).thenReturn(contatoCriador);
        Mockito.when(contatoRepository.findByUsuarioAndUsuarioConvidado(usuarioConvidado,usuarioCriador)).thenReturn(contatoConvidado);

        deletarAmizadeService.deletar(idCriador,idConvidado);

        Mockito.verify(contatoRepository,Mockito.times(2)).delete(contatoArgumentCaptor.capture());

        Contato contatoCriadorCapturado = contatoArgumentCaptor.getAllValues().get(0);
        Assert.assertEquals(contatoCriador,contatoCriadorCapturado);

        Contato contatoConvidadoCapturado = contatoArgumentCaptor.getAllValues().get(1);
        Assert.assertEquals(contatoConvidado,contatoConvidadoCapturado);


    }
}