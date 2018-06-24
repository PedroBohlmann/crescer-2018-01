package br.com.cwi.crescer.oldflix.service.filme;

import br.com.cwi.crescer.oldflix.dominio.Filme;
import br.com.cwi.crescer.oldflix.dominio.repository.IFilmeRepository;
import br.com.cwi.crescer.oldflix.exception.FilmeNaoCadastrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeletarFilmePorIdService {

    @Autowired
    private IFilmeRepository repository;

    public void deletar(Long id){
        Filme filme = repository.findById(id).orElseThrow(()->new FilmeNaoCadastrado(id));

        repository.delete(filme);
    }
}
