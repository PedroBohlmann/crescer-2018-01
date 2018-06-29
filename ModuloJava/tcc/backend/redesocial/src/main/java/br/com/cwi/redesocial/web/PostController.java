package br.com.cwi.redesocial.web;

import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.security.UserPrincipal;
import br.com.cwi.redesocial.service.mapeamento.MapearPostService;
import br.com.cwi.redesocial.service.post.CriarNovoPostService;
import br.com.cwi.redesocial.web.model.request.PostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/post")
@RestController
public class PostController {

    @Autowired
    private CriarNovoPostService criarNovoPostService;

    @Autowired
    private MapearPostService mapearPostService;

    @PostMapping
    public void criar(@AuthenticationPrincipal UserPrincipal usuarioLogado, @RequestBody PostRequest request){
        Post postMapeado = mapearPostService.mapearPostRequestParaPost(request);

        criarNovoPostService.criar(usuarioLogado.getEmail(),postMapeado);

    }
}
