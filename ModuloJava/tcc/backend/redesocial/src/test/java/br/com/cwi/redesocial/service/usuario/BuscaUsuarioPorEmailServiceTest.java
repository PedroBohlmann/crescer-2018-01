package br.com.cwi.redesocial.service.usuario;

import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IUsuarioRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscaUsuarioPorEmailServiceTest {

    @Mock
    private IUsuarioRepository usuarioRepository;

    @InjectMocks
    private BuscaUsuarioPorEmailService buscaUsuarioPorEmailService;

    @Test(expected = IllegalArgumentException.class)
    public void testaBuscaDeUsuarioComEmailVazio(){
        buscaUsuarioPorEmailService.buscar("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaBuscaDeUsuarioComEmailNulo(){
        buscaUsuarioPorEmailService.buscar(null);
    }

    @Test
    public void testaBuscaDeUsuarioQueExiste(){
        Usuario usuario = new Usuario();
        String email = "pedroka@gmail.com";
        usuario.setEmail(email);
        Mockito.when(usuarioRepository.findByEmail(email)).thenReturn(Optional.of(usuario));

        Usuario usuarioCarregado = buscaUsuarioPorEmailService.buscar(email);

        Assert.assertEquals(usuario,usuarioCarregado);
    }
}
