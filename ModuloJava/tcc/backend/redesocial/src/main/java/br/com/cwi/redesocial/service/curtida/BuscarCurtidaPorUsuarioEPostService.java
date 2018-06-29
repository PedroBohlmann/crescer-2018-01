package br.com.cwi.redesocial.service.curtida;

import br.com.cwi.redesocial.dominio.Curtida;
import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.ICurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarCurtidaPorUsuarioEPostService {

    @Autowired
    private ICurtidaRepository curtidaRepository;

    public Curtida buscar(Usuario usuario, Post post){
        return null;
    }

}
