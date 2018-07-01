package br.com.cwi.redesocial.web;

import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.security.UserPrincipal;
import br.com.cwi.redesocial.service.mapeamento.MapearPostService;
import br.com.cwi.redesocial.service.post.*;
import br.com.cwi.redesocial.web.model.request.AtualizarPostRequest;
import br.com.cwi.redesocial.web.model.request.PostRequest;
import br.com.cwi.redesocial.web.model.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/post")
@RestController
public class PostController {

    @Autowired
    private CriarNovoPostService criarNovoPostService;

    @Autowired
    private MapearPostService mapearPostService;

    @Autowired
    private ListarPostsService listarPostsService;

    @Autowired
    private AtualizarVisibilidadePostService atualizarVisibilidadePostService;

    @Autowired
    private BuscarPostPublicoPorIdService buscarPostPublicoPorIdService;

    @PostMapping
    public void criar(@AuthenticationPrincipal UserPrincipal usuarioLogado, @RequestBody PostRequest request){
        Post postMapeado = mapearPostService.mapearPostRequestParaPost(request);

        criarNovoPostService.criar(usuarioLogado.getEmail(),postMapeado);

    }

    @GetMapping("/timeline/{numeroPagina}")
    public Page<PostResponse> timelineDoUsuario(@AuthenticationPrincipal UserPrincipal usuarioLogado,@PathVariable("numeroPagina")int numeroPagina){
        Page<PostResponse> pagina = listarPostsService.listar(usuarioLogado.getId(),new PageRequest(numeroPagina,10));
        return pagina;
    }

    @GetMapping("/{idPost}")
    public PostResponse post(@AuthenticationPrincipal UserPrincipal usuarioLogado,@PathVariable("idPost")Long idPost){
        return mapearPostService.mapearPostParaResponse(buscarPostPublicoPorIdService.buscar(idPost));
    }

    @PutMapping("/{idPost}")
    public void atualizar(@AuthenticationPrincipal UserPrincipal usuarioLogado, @PathVariable("idPost")Long idPost, @RequestBody AtualizarPostRequest request){
        atualizarVisibilidadePostService.atualizar(idPost,request.getVisibilidade());
    }
}
