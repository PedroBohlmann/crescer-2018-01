package br.com.cwi.redesocial.service.curtida;

import br.com.cwi.redesocial.dominio.Curtida;
import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.ICurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class DeletarCurtidaService {

    @Autowired
    private ICurtidaRepository curtidaRepository;

    @Transactional
    public void deletar(Curtida curitida){
        if(Objects.isNull(curitida)){
            throw new IllegalArgumentException("Curtida nula");
        }

        curtidaRepository.delete(curitida);
    }
}
