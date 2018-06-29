package br.com.cwi.redesocial.web;


import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.security.AuthenticationService;
import br.com.cwi.redesocial.security.UserPrincipal;
import br.com.cwi.redesocial.service.cliente.AtualizaUsuarioService;
import br.com.cwi.redesocial.service.cliente.CadastraUsuarioService;
import br.com.cwi.redesocial.service.login.LoginService;
import br.com.cwi.redesocial.service.mapeamento.MapearUsuarioService;
import br.com.cwi.redesocial.web.model.request.LoginRequest;
import br.com.cwi.redesocial.web.model.request.UsuarioRequest;
import br.com.cwi.redesocial.web.model.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping()
    @Secured("ROLE_USER")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void atualizar(@AuthenticationPrincipal UserPrincipal usuarioLogado,@RequestBody UsuarioRequest request){
        Usuario usuarioMapeado = mapearUsuarioService.mapearUsuarioRequestParaUsuario(request);
        atualizaUsuarioService.atualiza(usuarioLogado.getEmail(),usuarioMapeado);
    }

}
