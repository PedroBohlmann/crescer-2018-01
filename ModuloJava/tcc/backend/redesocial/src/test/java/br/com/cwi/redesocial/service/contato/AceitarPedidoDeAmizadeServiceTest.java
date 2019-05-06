package br.com.cwi.redesocial.service.contato;

import br.com.cwi.redesocial.dominio.Contato;
import br.com.cwi.redesocial.dominio.StatusContato;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IContatoRepository;
import br.com.cwi.redesocial.service.usuario.BuscarUsuarioPorIdService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AceitarPedidoDeAmizadeServiceTest {

    @Mock
    private IContatoRepository contatoRepository;

    @Mock
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @InjectMocks
    private AceitarPedidoDeAmizadeService aceitarPedidoDeAmizadeService;

    @Captor
    private ArgumentCaptor<Contato> contatoArgumentCaptor;

    @Test(expected = IllegalArgumentException.class)
    public void testaAceitarSemUsuarioComIdCriador(){
        aceitarPedidoDeAmizadeService.aceitar(1L,1L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaAceitarSemUsuarioConvidado(){
        Long idCriador =1L;
        Usuario usuarioCriador = new Usuario();
        usuarioCriador.setId(idCriador);

        Long idConvidado = 2L;

        Mockito.when(buscarUsuarioPorIdService.buscar(idCriador)).thenReturn(usuarioCriador);

        aceitarPedidoDeAmizadeService.aceitar(idCriador,idConvidado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaAceitarConviteSemConvite(){
        Long idCriador =1L;
        Usuario usuarioCriador = new Usuario();
        usuarioCriador.setId(idCriador);

        Long idConvidado = 2L;
        Usuario usuarioConvidado = new Usuario();
        usuarioConvidado.setId(idConvidado);

        Mockito.when(buscarUsuarioPorIdService.buscar(idCriador)).thenReturn(usuarioCriador);
        Mockito.when(buscarUsuarioPorIdService.buscar(idConvidado)).thenReturn(usuarioConvidado);

        aceitarPedidoDeAmizadeService.aceitar(idCriador,idConvidado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaAceitarConviteJáSendoAmigos(){
        Long idCriador =1L;
        Usuario usuarioCriador = new Usuario();
        usuarioCriador.setId(idCriador);

        Long idConvidado = 2L;
        Usuario usuarioConvidado = new Usuario();
        usuarioConvidado.setId(idConvidado);

        Contato contato = new Contato();
        Long idContato = 1L;
        contato.setId(idContato);
        contato.setStatusContato(StatusContato.AMIGO);
        contato.setUsuario(usuarioCriador);
        contato.setUsuarioConvidado(usuarioConvidado);

        Mockito.when(buscarUsuarioPorIdService.buscar(idCriador)).thenReturn(usuarioCriador);
        Mockito.when(buscarUsuarioPorIdService.buscar(idConvidado)).thenReturn(usuarioConvidado);
        Mockito.when(contatoRepository.findByUsuarioAndUsuarioConvidado(usuarioCriador,usuarioConvidado)).thenReturn(contato);

        aceitarPedidoDeAmizadeService.aceitar(idCriador,idConvidado);
    }

    @Test
    public void testaAceitarConviteComConviteValido(){
        Long idCriador =1L;
        Usuario usuarioCriador = new Usuario();
        usuarioCriador.setId(idCriador);

        Long idConvidado = 2L;
        Usuario usuarioConvidado = new Usuario();
        usuarioConvidado.setId(idConvidado);

        Contato contato = new Contato();
        Long idContato = 1L;
        contato.setId(idContato);
        contato.setStatusContato(StatusContato.CONVIDADO);
        contato.setUsuario(usuarioCriador);
        contato.setUsuarioConvidado(usuarioConvidado);

        Contato contatoConvidado = new Contato();
        Long idContatoConvidado = 2L;
        contatoConvidado.setId(idContato);
        contatoConvidado.setStatusContato(StatusContato.CONVIDADO);
        contatoConvidado.setUsuario(usuarioConvidado);
        contatoConvidado.setUsuarioConvidado(usuarioCriador);

        Mockito.when(buscarUsuarioPorIdService.buscar(idCriador)).thenReturn(usuarioCriador);
        Mockito.when(buscarUsuarioPorIdService.buscar(idConvidado)).thenReturn(usuarioConvidado);
        Mockito.when(contatoRepository.findByUsuarioAndUsuarioConvidado(usuarioCriador,usuarioConvidado)).thenReturn(contato);
        Mockito.when(contatoRepository.findByUsuarioAndUsuarioConvidado(usuarioConvidado,usuarioCriador)).thenReturn(contatoConvidado);

        aceitarPedidoDeAmizadeService.aceitar(idCriador,idConvidado);

        Mockito.verify(contatoRepository,Mockito.times(2)).save(contatoArgumentCaptor.capture());

        List<Contato> contatos = contatoArgumentCaptor.getAllValues();

        Contato contatoCapturado = contatos.get(0);

        Assert.assertEquals(contatoCapturado.getUsuario(),usuarioCriador);
        Assert.assertEquals(contatoCapturado.getUsuarioConvidado(),usuarioConvidado);
        Assert.assertEquals(contatoCapturado.getStatusContato(),StatusContato.AMIGO);

        Contato contatoConvidadoCapturado = contatos.get(1);

        Assert.assertEquals(contatoConvidadoCapturado.getUsuario(),usuarioConvidado);
        Assert.assertEquals(contatoConvidadoCapturado.getUsuarioConvidado(),usuarioCriador);
        Assert.assertEquals(contatoConvidadoCapturado.getStatusContato(),StatusContato.AMIGO);

    }
}
