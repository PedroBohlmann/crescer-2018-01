package br.com.cwi.crescer.oldflix.service.fita;

import br.com.cwi.crescer.oldflix.dominio.Fita;
import br.com.cwi.crescer.oldflix.dominio.repository.IFitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListarFitasService {
    @Autowired
    private IFitaRepository repository;

    public List<Fita> listar(){
        return repository.findAll();
    }
}
