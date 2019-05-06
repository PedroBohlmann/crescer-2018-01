package br.com.cwi.redesocial.web;


import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.security.AuthenticationService;
import br.com.cwi.redesocial.security.UserPrincipal;
import br.com.cwi.redesocial.service.contato.AceitarPedidoDeAmizadeService;
import br.com.cwi.redesocial.service.contato.ConvidarParaAmizadeService;
import br.com.cwi.redesocial.service.contato.DeletarAmizadeService;
import br.com.cwi.redesocial.service.usuario.AtualizaUsuarioService;
import br.com.cwi.redesocial.service.usuario.BuscarAmigosDeUmUsuarioService;
import br.com.cwi.redesocial.service.usuario.BuscarUsuarioPorIdService;
import br.com.cwi.redesocial.service.usuario.CadastraUsuarioService;
import br.com.cwi.redesocial.service.login.LoginService;
import br.com.cwi.redesocial.service.mapeamento.MapearUsuarioService;
import br.com.cwi.redesocial.web.model.request.ContatoConviteRequest;
import br.com.cwi.redesocial.web.model.request.LoginRequest;
import br.com.cwi.redesocial.web.model.request.UsuarioRequest;
import br.com.cwi.redesocial.web.model.response.LoginResponse;
import br.com.cwi.redesocial.web.model.response.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/public/usuario")
@RestController
public class UsuarioController {

    @Autowired
    private CadastraUsuarioService cadastraUsuarioService;

    @Autowired
    private MapearUsuarioService mapearUsuarioService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private AtualizaUsuarioService atualizaUsuarioService;

    @Autowired
    private ConvidarParaAmizadeService convidarParaAmizadeService;

    @Autowired
    private AceitarPedidoDeAmizadeService aceitarPedidoDeAmizadeService;

    @Autowired
    private DeletarAmizadeService deletarAmizadeService;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    private BuscarAmigosDeUmUsuarioService buscarAmigosDeUmUsuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastra(@RequestBody UsuarioRequest request){
        cadastraUsuarioService.cadastra(mapearUsuarioService.mapearUsuarioRequestParaUsuario(request));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse logar(@RequestBody LoginRequest request){

        String email = request.getEmail();
        String senha = loginService.login(email,request.getSenha());

        String token = authenticationService.authenticate(email, senha);

        return new LoginResponse(token);
    }

    @GetMapping("/amigos")
    public List<UsuarioResponse> getAmigos(@AuthenticationPrincipal UserPrincipal usuarioLogado){
        return buscarAmigosDeUmUsuarioService.listar(usuarioLogado.getId());
    }

    @GetMapping("/{idUsuario}")
    @Secured("ROLE_USER")
    public UsuarioResponse buscar(@AuthenticationPrincipal UserPrincipal usuarioLogado,@PathVariable("idUsuario")Long id){
        return mapearUsuarioService.mapearUsuarioParaUsuarioResponse(buscarUsuarioPorIdService.buscar(id));
    }

    @PutMapping()
    @Secured("ROLE_USER")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void atualizar(@AuthenticationPrincipal UserPrincipal usuarioLogado,@RequestBody UsuarioRequest request){
        Usuario usuarioMapeado = mapearUsuarioService.mapearUsuarioRequestParaUsuario(request);
        atualizaUsuarioService.atualiza(usuarioLogado.getEmail(),usuarioMapeado);
    }

    @PostMapping("/convidar")
    @Secured("ROLE_USER")
    @ResponseStatus(HttpStatus.CREATED)
    public void convidar(@AuthenticationPrincipal UserPrincipal usuarioLogado,@RequestBody ContatoConviteRequest request){
        convidarParaAmizadeService.criarAmizada(usuarioLogado.getEmail(),request.getEmailConvidado());
    }

    @PostMapping("/aceitar/{idConvidado}")
    @Secured("ROLE_USER")
    @ResponseStatus(HttpStatus.CREATED)
    public void convidar(@AuthenticationPrincipal UserPrincipal usuarioLogado,@PathVariable("idConvidado") Long convidado){
        aceitarPedidoDeAmizadeService.aceitar(usuarioLogado.getId(),convidado);
    }

    @DeleteMapping("/excluir/{idConvidado}")
    @Secured("ROLE_USER")
    @ResponseStatus(HttpStatus.CREATED)
    public void deletar(@AuthenticationPrincipal UserPrincipal usuarioLogado,@PathVariable("idConvidado") Long convidado){
        deletarAmizadeService.deletar(usuarioLogado.getId(),convidado);
    }

}
