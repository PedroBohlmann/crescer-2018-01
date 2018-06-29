package br.com.cwi.redesocial.service.login;

import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IUsuarioRepository;
import br.com.cwi.redesocial.service.cliente.BuscaUsuarioPorEmailService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    @Mock
    private IUsuarioRepository usuarioRepository;

    @Mock
    private BuscaUsuarioPorEmailService buscaUsuarioPorEmailService;

    @InjectMocks
    private LoginService loginService;

    @Test(expected = IllegalArgumentException.class)
    public void testaLoginEnviandoSenhaNula(){
        loginService.login("pedroka@gmail.com",null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaLoginComSenhaVazia(){
        loginService.login("pedroka@gmail.com","");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaLoginComSenhasDiferentes(){
        Usuario usuario = new Usuario();
        String email = "pedroka@gmail.com";
        String senha = "123";

        usuario.setEmail(email);
        usuario.setSenha(BCrypt.hashpw(senha,BCrypt.gensalt()));

        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(usuario);

        loginService.login(email,"321");
    }

    @Test
    public void testaLoginComSenhasIguais(){
        Usuario usuario = new Usuario();
        String email = "pedroka@gmail.com";
        String senha = "123";

        usuario.setEmail(email);
        usuario.setSenha(BCrypt.hashpw(senha,BCrypt.gensalt()));

        Mockito.when(buscaUsuarioPorEmailService.buscar(email)).thenReturn(usuario);

        String senhaResultado = loginService.login(email,senha);

        Assert.assertTrue(BCrypt.checkpw(senha,senhaResultado));
    }
}
