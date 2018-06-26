package br.com.cwi.crescer.oldflix.service.filme;

import br.com.cwi.crescer.oldflix.dominio.Filme;
import br.com.cwi.crescer.oldflix.dominio.repository.IFilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class AtualizarFilmePorIdService {

    @Autowired
    private IFilmeRepository repository;

    public void atualizar(Long id,Filme filme){
        if(Objects.isNull(id)){
            throw new IllegalArgumentException("id invalido");
        }

        filme.setId(id);

        repository.save(filme);
    }
}
