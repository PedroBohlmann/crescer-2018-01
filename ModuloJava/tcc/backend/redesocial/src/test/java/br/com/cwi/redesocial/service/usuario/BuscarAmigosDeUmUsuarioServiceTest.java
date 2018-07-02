package br.com.cwi.redesocial.service.usuario;

import br.com.cwi.redesocial.dominio.Contato;
import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IContatoRepository;
import br.com.cwi.redesocial.service.mapeamento.MapearUsuarioService;
import br.com.cwi.redesocial.web.model.response.UsuarioResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarAmigosDeUmUsuarioServiceTest {

    @Mock
    private IContatoRepository contatoRepository;

    @Mock
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Mock
    private MapearUsuarioService mapearUsuarioService;

    @InjectMocks
    private BuscarAmigosDeUmUsuarioService buscarAmigosDeUmUsuarioService;

    @Test(expected = IllegalArgumentException.class)
    public void testListarAmigosComIdNulo(){
        buscarAmigosDeUmUsuarioService.listar(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaListarAmigoDeUmUsuarioNaoCadastrado(){
        buscarAmigosDeUmUsuarioService.listar(1L);
    }

    @Test
    public void testaListarAmigoDeUmUsuarioComSucesso(){
        Usuario usuario = new Usuario();
        Long idUsuario = 1L;
        usuario.setId(idUsuario);
        usuario.setPosts(new ArrayList<>());

        Usuario usuarioAmigo = new Usuario();

        List<Usuario> amigos = new ArrayList<>();
        amigos.add(usuarioAmigo);

        Contato contato = new Contato();
        contato.setUsuario(usuario);
        contato.setUsuarioConvidado(usuarioAmigo);

        List<Contato> contatos = new ArrayList<>();
        contatos.add(contato);

        UsuarioResponse usuarioResponse = new UsuarioResponse();

        Mockito.when(mapearUsuarioService.mapearUsuarioParaUsuarioResponse(usuarioAmigo)).thenReturn(usuarioResponse);

        Mockito.when(buscarUsuarioPorIdService.buscar(idUsuario)).thenReturn(usuario);

        Mockito.when(contatoRepository.findByUsuario(usuario)).thenReturn(contatos);

        List<UsuarioResponse> lista = buscarAmigosDeUmUsuarioService.listar(idUsuario);

        Assert.assertEquals(usuarioResponse, lista.get(0));
    }


}
