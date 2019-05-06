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
public class BuscarUsuarioPorIdServiceTest {

    @Mock
    private IUsuarioRepository usuarioRepository;

    @InjectMocks
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Test(expected = IllegalArgumentException.class)
    public void testaBuscarComIdNulo(){
        Long idUsuario = null;
        buscarUsuarioPorIdService.buscar(idUsuario);
    }

    @Test
    public void testaBuscarSemUsuarioCadastrado(){
        Long idUsuario = 1L;
        Optional<Usuario> optionalUsuario = Optional.empty();

        Mockito.when(usuarioRepository.findById(idUsuario)).thenReturn(optionalUsuario);

        Usuario usuario = buscarUsuarioPorIdService.buscar(idUsuario);

        Assert.assertNull(usuario);
    }

    @Test
    public void testaBuscarCOmUsuarioCadastrado(){
        Long idUsuario = 1L;
        Usuario usuario = new Usuario();
        Optional<Usuario> optionalUsuario = Optional.of(usuario);

        Mockito.when(usuarioRepository.findById(idUsuario)).thenReturn(optionalUsuario);

        Usuario usuarioCapturado = buscarUsuarioPorIdService.buscar(idUsuario);

        Assert.assertEquals(usuario,usuarioCapturado);
    }

}
