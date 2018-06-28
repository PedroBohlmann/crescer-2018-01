package br.com.cwi.redesocial.web;


import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.service.cliente.CadastraUsuarioService;
import br.com.cwi.redesocial.service.cliente.MapearClienteService;
import br.com.cwi.redesocial.web.model.request.UsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {

    @Autowired
    private CadastraUsuarioService cadastraUsuarioService;

    @Autowired
    private MapearClienteService mapearClienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastra(@RequestBody UsuarioRequest request){
        cadastraUsuarioService.cadastra(mapearClienteService.mapearUsuarioRequestParaUsuario(request));
    }

}
