package br.com.cwi.crescer.oldflix.service.filme;

import br.com.cwi.crescer.oldflix.dominio.Filme;
import br.com.cwi.crescer.oldflix.dominio.repository.IFilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BuscarFilmePeloTituloService {

    @Autowired
    private IFilmeRepository repository;

    public Filme buscarFilme(String titulo){
        return repository
                .findFilmeByTitulo(titulo)
                .orElseThrow(()->new IllegalArgumentException("Sem filme com esse titulo"+titulo));
    }
}
