package br.com.cwi.redesocial.service.mapeamento;

import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.web.model.request.UsuarioRequest;
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
    public void testaMepeamentoUsurioRequestParaUsuarioCorreto(){
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
}
