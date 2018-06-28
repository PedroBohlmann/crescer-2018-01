package br.com.cwi.redesocial.service.usuario;

import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IUsuarioRepository;
import br.com.cwi.redesocial.service.cliente.BuscaUsuarioPorEmailService;
import br.com.cwi.redesocial.service.cliente.CadastraUsuarioService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class CadastraUsuarioServiceTest {

    @Mock
    private IUsuarioRepository usuarioRepository;

    @Mock
    private BuscaUsuarioPorEmailService buscaUsuarioPorEmailService;

    @InjectMocks
    private CadastraUsuarioService cadastraUsuarioService;

    @Captor
    private ArgumentCaptor<Usuario> captadorDeUsuario;

    @Test(expected = IllegalArgumentException.class)
    public void testaCadastroDeUsuarioJáExistenteJogaUmaExcecao(){
        Usuario usuario = new Usuario();
        usuario.setNome("Pedro");
        usuario.setSenha("1234");
        usuario.setDataDeNascimento(LocalDate.now());

        String email ="pedro@gmail.com";
        usuario.setEmail(email);

        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(usuario);

        cadastraUsuarioService.cadastra(usuario);
    }

    @Test
    public void testaSeUsuarioASerCadastradoEOMesmoEnviado(){
        Usuario usuario = new Usuario();
        usuario.setNome("Pedro");
        usuario.setSenha("1234");
        usuario.setDataDeNascimento(LocalDate.now());

        String email ="pedro@gmail.com";
        usuario.setEmail(email);

        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(null);

        cadastraUsuarioService.cadastra(usuario);

        Mockito.verify(usuarioRepository,Mockito.times(1)).save(captadorDeUsuario.capture());

        Usuario usuarioCadastrado = captadorDeUsuario.getValue();

        Assert.assertEquals(usuario,usuarioCadastrado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaEnviandoUsuarioNuloMandaException(){
        cadastraUsuarioService.cadastra(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaEnviandoUsuarioComEmailNulo(){
        Usuario usuario = new Usuario();
        usuario.setNome("Pedro");
        usuario.setSenha("1234");
        usuario.setDataDeNascimento(LocalDate.now());

        String email ="pedro@gmail.com";

        cadastraUsuarioService.cadastra(usuario);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaEnviandoUsuarioComNomeNulo(){
        Usuario usuario = new Usuario();
        usuario.setNome(null);
        usuario.setSenha("1234");
        usuario.setDataDeNascimento(LocalDate.now());

        String email ="pedro@gmail.com";
        usuario.setEmail(email);

        cadastraUsuarioService.cadastra(usuario);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaEnviandoUsuarioComSenhaNulo(){
        Usuario usuario = new Usuario();
        usuario.setNome("Pedro");
        usuario.setSenha(null);
        usuario.setDataDeNascimento(LocalDate.now());

        String email ="pedro@gmail.com";
        usuario.setEmail(email);

        cadastraUsuarioService.cadastra(usuario);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaEnviandoUsuarioComDataDeNascimentoNulo(){
        Usuario usuario = new Usuario();
        usuario.setNome("Pedro");
        usuario.setSenha("1234");
        usuario.setDataDeNascimento(null);

        String email ="pedro@gmail.com";
        usuario.setEmail(email);

        cadastraUsuarioService.cadastra(usuario);
    }
}
