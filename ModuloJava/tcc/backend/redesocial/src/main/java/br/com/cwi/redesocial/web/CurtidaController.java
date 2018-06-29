package br.com.cwi.redesocial.web;

import br.com.cwi.redesocial.security.UserPrincipal;
import br.com.cwi.redesocial.service.curtida.CriarCurtidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/curtida")
@RestController
public class CurtidaController {

    @Autowired
    private CriarCurtidaService criarCurtidaService;

    @PostMapping("/{idPost}")
    public void criar(@AuthenticationPrincipal UserPrincipal usuarioLogado, @PathVariable("idPost")Long id){
        criarCurtidaService.criar(usuarioLogado.getEmail(),id);
    }
}
