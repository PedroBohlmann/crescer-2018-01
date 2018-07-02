package br.com.cwi.redesocial.service.mapeamento;

import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.web.model.request.UsuarioRequest;
import br.com.cwi.redesocial.web.model.response.UsuarioResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class MapearUsuarioServiceTest {

    @InjectMocks
    private MapearUsuarioService mapearUsuarioService;

    @Test(expected = IllegalArgumentException.class)
    public void testaMapeandoUsuarioRequestParaUsuarioComUsuarioNulo(){
        Usuario usuarioMapeado = mapearUsuarioService.mapearUsuarioRequestParaUsuario(null);
    }

    @Test
    public void testaMepeamentoUsuarioRequestParaUsuarioCorreto(){
        UsuarioRequest request = new UsuarioRequest();
        request.setId(1L);
        request.setApelido("Pedroka");
        request.setDataDeNascimento(LocalDate.now());
        request.setEmail("pedro@gmail.com");
        request.setNome("Pedro");
        request.setImagemUrl("www.google.com");
        request.setSenha("123");

        Usuario usuarioMapeado = mapearUsuarioService.mapearUsuarioRequestParaUsuario(request);

        Assert.assertEquals(request.getId(),usuarioMapeado.getId());
        Assert.assertEquals(request.getApelido(),usuarioMapeado.getApelido());
        Assert.assertEquals(request.getDataDeNascimento(),usuarioMapeado.getDataDeNascimento());
        Assert.assertEquals(request.getEmail(),usuarioMapeado.getEmail());
        Assert.assertEquals(request.getNome(),usuarioMapeado.getNome());
        Assert.assertEquals(request.getImagemUrl(),usuarioMapeado.getImagemUrl());
        Assert.assertEquals(request.getSenha(),usuarioMapeado.getSenha());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaMapeamentoUsuarioParaResponseComUsuarioNulo(){
        mapearUsuarioService.mapearUsuarioParaUsuarioResponse(null);
    }

    @Test
    public void testaMapeamentoUsuarioParaResponseComSucesso(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("pedro");
        usuario.setEmail("pedro@gmail.com");
        usuario.setApelido("pedroka");
        usuario.setDataDeNascimento(LocalDate.now());
        usuario.setImagemUrl("www.google.com");

        UsuarioResponse response = mapearUsuarioService.mapearUsuarioParaUsuarioResponse(usuario);

        Assert.assertEquals(usuario.getId(),response.getId());
        Assert.assertEquals(usuario.getNome(),response.getNome());
        Assert.assertEquals(usuario.getEmail(),response.getEmail());
        Assert.assertEquals(usuario.getApelido(),response.getApelido());
        Assert.assertEquals(usuario.getId(),response.getId());
        Assert.assertEquals(usuario.getDataDeNascimento(),response.getDataDeNascimento());
        Assert.assertEquals(usuario.getImagemUrl(),response.getImagemUrl());
    }
}
