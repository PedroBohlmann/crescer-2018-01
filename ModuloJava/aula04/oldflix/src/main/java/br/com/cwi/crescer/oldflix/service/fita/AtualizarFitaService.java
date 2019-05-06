package br.com.cwi.crescer.oldflix.service.fita;

import br.com.cwi.crescer.oldflix.dominio.Fita;
import br.com.cwi.crescer.oldflix.dominio.repository.IFitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AtualizarFitaService {
    @Autowired
    private IFitaRepository repository;

    @Autowired
    private BuscarFitaPorIdService buscarFitaPorIdService;

    public void atualizar(Long id,Fita fita){
        Fita fitaCarregada = buscarFitaPorIdService.buscar(id);

        fitaCarregada.atualiza(fita);

        repository.save(fitaCarregada);
    }
}
