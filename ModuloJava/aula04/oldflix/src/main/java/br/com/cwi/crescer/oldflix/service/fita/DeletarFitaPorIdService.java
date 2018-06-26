package br.com.cwi.crescer.oldflix.service.fita;

import br.com.cwi.crescer.oldflix.dominio.Fita;
import br.com.cwi.crescer.oldflix.dominio.repository.IFitaRepository;
import br.com.cwi.crescer.oldflix.exception.FitaNaoCadastrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class DeletarFitaPorIdService {

    @Autowired
    private IFitaRepository repository;

    public void deletar(Long id){
        if(Objects.isNull(id)){
            throw new IllegalArgumentException("id invalido");
        }

        Fita fita = repository.findById(id).orElseThrow(()->new FitaNaoCadastrada(id));

        repository.delete(fita);
    }
}
