package br.com.cwi.redesocial.web;

import br.com.cwi.redesocial.dominio.Comentario;
import br.com.cwi.redesocial.security.UserPrincipal;
import br.com.cwi.redesocial.service.comentario.CriarComentarioService;
import br.com.cwi.redesocial.service.mapeamento.MapearComentarioService;
import br.com.cwi.redesocial.web.model.request.ComentarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comentario")
@RestController
public class ComentarioController {

    @Autowired
    private CriarComentarioService criarComentarioService;

    @Autowired
    private MapearComentarioService mapearComentarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@AuthenticationPrincipal UserPrincipal usuarioLogado, @RequestBody ComentarioRequest request){
        Comentario comentario = mapearComentarioService.mapearComentarioRequestParaComentario(request);
        criarComentarioService.criar(usuarioLogado.getEmail(),request.getIdPost(),comentario);
    }
}
