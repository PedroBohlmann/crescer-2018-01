package br.com.cwi.redesocial.service.contato;

import br.com.cwi.redesocial.dominio.Contato;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IContatoRepository;
import br.com.cwi.redesocial.service.usuario.BuscaUsuarioPorEmailService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ConvidarParaAmizadeServiceTest {

    @Mock
    private IContatoRepository contatoRepository;

    @Mock
    private BuscaUsuarioPorEmailService buscaUsuarioPorEmailService;

    @InjectMocks
    private ConvidarParaAmizadeService convidarParaAmizadeService;

    @Captor
    private ArgumentCaptor<Contato> contatoArgumentCaptor;


    @Test(expected = IllegalArgumentException.class)
    public void testaConvidarSemUsuarioCriadorExistenteNoBanco(){
        convidarParaAmizadeService.criarAmizada("pedroka@gmai.com","teste@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaConvidarSemUsuarioConvidadoExistenteNoBanco(){
        String emailCriador = "pedroka@gmai.com";
        String emailConvidado = "teste@gmail.com";

        Mockito.when(buscaUsuarioPorEmailService.buscar(emailCriador)).thenReturn(new Usuario());

        convidarParaAmizadeService.criarAmizada(emailCriador,emailConvidado);
    }

    @Test
    public void testaConvidarComDadosValidos(){
        String emailCriador = "pedroka@gmai.com";
        Usuario usuarioCriador = new Usuario();
        usuarioCriador.setEmail(emailCriador);

        String emailConvidado = "teste@gmail.com";
        Usuario usuarioConvidado = new Usuario();
        usuarioConvidado.setEmail(emailConvidado);

        Mockito.when(buscaUsuarioPorEmailService.buscar(emailCriador)).thenReturn(usuarioCriador);
        Mockito.when(buscaUsuarioPorEmailService.buscar(emailConvidado)).thenReturn(usuarioConvidado);

        convidarParaAmizadeService.criarAmizada(emailCriador,emailConvidado);

        Mockito.verify(contatoRepository,Mockito.times(2)).save(contatoArgumentCaptor.capture());


        List<Contato> contatoCriador = contatoArgumentCaptor.getAllValues();
        Assert.assertEquals(usuarioCriador,contatoCriador.get(0).getUsuario());
        Assert.assertEquals(usuarioConvidado,contatoCriador.get(0).getUsuarioConvidado());

        Assert.assertEquals(usuarioConvidado,contatoCriador.get(1).getUsuario());
        Assert.assertEquals(usuarioCriador,contatoCriador.get(1).getUsuarioConvidado());
    }
}
