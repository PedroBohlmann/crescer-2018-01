package br.com.cwi.redesocial.service.usuario;

import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IUsuarioRepository;
import br.com.cwi.redesocial.service.cliente.AtualizaUsuarioService;
import br.com.cwi.redesocial.service.cliente.BuscaUsuarioPorEmailService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class AtualizaUsuarioServiceTest {

    @Mock
    private IUsuarioRepository usuarioRepository;

    @Mock
    private BuscaUsuarioPorEmailService emailService;

    @InjectMocks
    private AtualizaUsuarioService atualizaUsuarioService;

    @Captor
    private ArgumentCaptor<Usuario> usuarioCapturador;

    @Test(expected = IllegalArgumentException.class)
    public void testeEditarComNomeNulo(){
        Usuario usuarioCarregado = new Usuario();
        String email="pedro@gmail.com";
        usuarioCarregado.setEmail(email);

        Usuario dadosNovos = new Usuario();

        Mockito.when(emailService.buscar(email)).thenReturn(usuarioCarregado);

        atualizaUsuarioService.atualiza(email,dadosNovos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeEditarComNomeVazio(){
        Usuario usuarioCarregado = new Usuario();
        String email="pedro@gmail.com";
        usuarioCarregado.setEmail(email);

        Usuario dadosNovos = new Usuario();
        dadosNovos.setNome("");

        Mockito.when(emailService.buscar(email)).thenReturn(usuarioCarregado);

        atualizaUsuarioService.atualiza(email,dadosNovos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaEditarComEmailNulo(){
        Usuario usuarioCarregado = new Usuario();
        String email="pedro@gmail.com";
        usuarioCarregado.setEmail(email);

        Usuario dadosNovos = new Usuario();
        dadosNovos.setNome("Pedroka");

        Mockito.when(emailService.buscar(email)).thenReturn(usuarioCarregado);

        atualizaUsuarioService.atualiza(email,dadosNovos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaEditarComEmailVazio(){
        Usuario usuarioCarregado = new Usuario();
        String email="pedro@gmail.com";
        usuarioCarregado.setEmail(email);

        Usuario dadosNovos = new Usuario();
        dadosNovos.setNome("Pedroka");
        dadosNovos.setEmail("");

        Mockito.when(emailService.buscar(email)).thenReturn(usuarioCarregado);

        atualizaUsuarioService.atualiza(email,dadosNovos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaEditarComSenhaNula(){
        Usuario usuarioCarregado = new Usuario();
        String email="pedro@gmail.com";
        usuarioCarregado.setEmail(email);

        Usuario dadosNovos = new Usuario();
        dadosNovos.setNome("Pedroka");
        dadosNovos.setEmail("pedroka@gmail.com");

        Mockito.when(emailService.buscar(email)).thenReturn(usuarioCarregado);

        atualizaUsuarioService.atualiza(email,dadosNovos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaEditarComSenhaVazia(){
        Usuario usuarioCarregado = new Usuario();
        String email="pedro@gmail.com";
        usuarioCarregado.setEmail(email);

        Usuario dadosNovos = new Usuario();
        dadosNovos.setNome("Pedroka");
        dadosNovos.setEmail("pedroka@gmail.com");
        dadosNovos.setSenha("");

        Mockito.when(emailService.buscar(email)).thenReturn(usuarioCarregado);

        atualizaUsuarioService.atualiza(email,dadosNovos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaEditarComDataDeNascimentoNula(){
        Usuario usuarioCarregado = new Usuario();
        String email="pedro@gmail.com";
        usuarioCarregado.setEmail(email);

        Usuario dadosNovos = new Usuario();
        dadosNovos.setNome("Pedroka");
        dadosNovos.setEmail("pedroka@gmail.com");
        dadosNovos.setSenha("123");

        Mockito.when(emailService.buscar(email)).thenReturn(usuarioCarregado);

        atualizaUsuarioService.atualiza(email,dadosNovos);
    }

    @Test
    public void testaEditarComDadosValidos(){
        Usuario usuarioCarregado = new Usuario();
        String email="pedro@gmail.com";
        usuarioCarregado.setEmail(email);

        Usuario dadosNovos = new Usuario();

        String nome = "Pedro";
        dadosNovos.setNome(nome);

        String emailNovo = "pedroka@gmail.com";
        dadosNovos.setEmail(emailNovo);

        String senha = "123";
        dadosNovos.setSenha(senha);

        LocalDate nascimento = LocalDate.now();
        dadosNovos.setDataDeNascimento(nascimento);

        String url = "www.googgle.com.br";
        dadosNovos.setImagemUrl(url);

        String apelido = "pedroka";
        dadosNovos.setApelido(apelido);


        Mockito.when(emailService.buscar(email)).thenReturn(usuarioCarregado);

        atualizaUsuarioService.atualiza(email,dadosNovos);

        Mockito.verify(usuarioRepository,Mockito.times(1)).save(usuarioCapturador.capture());

        Usuario usuarioCapturado = usuarioCapturador.getValue();

        Assert.assertEquals(nome,usuarioCapturado.getNome());
        Assert.assertEquals(emailNovo,usuarioCapturado.getEmail());
        Assert.assertEquals(nascimento,usuarioCapturado.getDataDeNascimento());
        Assert.assertEquals(url,usuarioCapturado.getImagemUrl());
        Assert.assertEquals(apelido,usuarioCapturado.getApelido());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeEditarUsuarioNaoExistente(){
        Usuario usuarioCarregado = new Usuario();
        String email="pedro@gmail.com";
        usuarioCarregado.setEmail(email);

        Usuario dadosNovos = new Usuario();

        String nome = "Pedro";
        dadosNovos.setNome(nome);

        String emailNovo = "pedroka@gmail.com";
        dadosNovos.setEmail(emailNovo);

        String senha = "123";
        dadosNovos.setSenha(senha);

        LocalDate nascimento = LocalDate.now();
        dadosNovos.setDataDeNascimento(nascimento);

        String url = "www.googgle.com.br";
        dadosNovos.setImagemUrl(url);

        String apelido = "pedroka";
        dadosNovos.setApelido(apelido);

        atualizaUsuarioService.atualiza(email,dadosNovos);
    }
}
