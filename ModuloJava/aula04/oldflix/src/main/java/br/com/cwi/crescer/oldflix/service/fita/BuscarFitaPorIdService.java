package br.com.cwi.crescer.oldflix.service.fita;

import br.com.cwi.crescer.oldflix.dominio.Fita;
import br.com.cwi.crescer.oldflix.dominio.repository.IFitaRepository;
import br.com.cwi.crescer.oldflix.exception.FitaNaoCadastrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class BuscarFitaPorIdService {
    @Autowired
    private IFitaRepository repository;

    public Fita buscar(Long id){
        if(Objects.isNull(id)){
            throw new IllegalArgumentException("id invalido");
        }

        return repository
                .findById(id)
                .orElseThrow(()->new FitaNaoCadastrada(id));
    }
}
