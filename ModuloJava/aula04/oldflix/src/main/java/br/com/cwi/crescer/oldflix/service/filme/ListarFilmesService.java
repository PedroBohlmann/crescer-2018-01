package br.com.cwi.crescer.oldflix.service.filme;

import br.com.cwi.crescer.oldflix.dominio.Filme;
import br.com.cwi.crescer.oldflix.dominio.repository.IFilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListarFilmesService {

    @Autowired
    private IFilmeRepository repository;

    public List<Filme> listar(){
        return repository.findAll();
    }
}
