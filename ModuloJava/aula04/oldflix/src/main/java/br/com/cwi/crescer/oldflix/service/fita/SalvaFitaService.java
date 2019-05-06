package br.com.cwi.crescer.oldflix.service.fita;

import br.com.cwi.crescer.oldflix.dominio.Filme;
import br.com.cwi.crescer.oldflix.dominio.Fita;
import br.com.cwi.crescer.oldflix.dominio.repository.IFilmeRepository;
import br.com.cwi.crescer.oldflix.dominio.repository.IFitaRepository;
import br.com.cwi.crescer.oldflix.exception.ClienteNaoCadastrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SalvaFitaService {

    @Autowired
    private IFitaRepository fitaRepository;

    @Autowired
    private IFilmeRepository filmeRepository;

    public void salvar(Long idFilme,Fita fita){
        Filme filmeCarregado = filmeRepository
                .findById(idFilme)
                .orElseThrow(()->new ClienteNaoCadastrado(idFilme));

        fita.setFilme(filmeCarregado);

        fitaRepository.save(fita);
    }
}
