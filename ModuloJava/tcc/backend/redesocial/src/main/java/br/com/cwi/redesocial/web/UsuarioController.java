package br.com.cwi.redesocial.web;


import br.com.cwi.redesocial.security.AuthenticationService;
import br.com.cwi.redesocial.service.cliente.CadastraUsuarioService;
import br.com.cwi.redesocial.service.cliente.LoginService;
import br.com.cwi.redesocial.service.cliente.MapearClienteService;
import br.com.cwi.redesocial.web.model.request.LoginRequest;
import br.com.cwi.redesocial.web.model.request.UsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/public/usuario")
@RestController
public class UsuarioController {

    @Autowired
    private CadastraUsuarioService cadastraUsuarioService;

    @Autowired
    private MapearClienteService mapearClienteService;


    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastra(@RequestBody UsuarioRequest request){
        cadastraUsuarioService.cadastra(mapearClienteService.mapearUsuarioRequestParaUsuario(request));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse logar(@RequestBody LoginRequest request){

        String email = request.getEmail();
        String senha = loginService.login(email,request.getSenha());

        String token = authenticationService.authenticate(email, senha);

        return new LoginResponse(token);
    }

}
