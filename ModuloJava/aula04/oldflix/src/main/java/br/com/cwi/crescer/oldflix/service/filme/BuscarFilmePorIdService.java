package br.com.cwi.crescer.oldflix.service.filme;

import br.com.cwi.crescer.oldflix.dominio.Filme;
import br.com.cwi.crescer.oldflix.dominio.repository.IFilmeRepository;
import br.com.cwi.crescer.oldflix.exception.FilmeNaoCadastrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class BuscarFilmePorIdService {

    @Autowired
    private IFilmeRepository repository;

    public Filme buscar(Long id){
        if(Objects.isNull(id)){
            throw new IllegalArgumentException("id invalido");
        }

        return repository
                .findById(id)
                .orElseThrow(()->new FilmeNaoCadastrado(id));
    }
}
