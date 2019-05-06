package br.com.cwi.crescer.oldflix.service.filme;

import br.com.cwi.crescer.oldflix.dominio.Filme;
import br.com.cwi.crescer.oldflix.dominio.repository.IFilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CriarNovoFilmeService {

    @Autowired
    private IFilmeRepository repository;

    public void criar(Filme filme){
        repository.save(filme);
    }
}
