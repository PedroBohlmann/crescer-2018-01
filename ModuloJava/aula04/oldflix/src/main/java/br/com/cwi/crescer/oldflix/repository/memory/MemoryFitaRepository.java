package br.com.cwi.crescer.oldflix.repository.memory;

import br.com.cwi.crescer.oldflix.dominio.Fita;
import br.com.cwi.crescer.oldflix.dominio.repository.IFitaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class MemoryFitaRepository implements IFitaRepository {

    private List<Fita> fitas = new ArrayList<>();

    @Override
    public List<Fita> findAll() {
        return fitas;
    }

    @Override
    public Optional<Fita> findById(Long id) {
        return fitas.stream().filter(f->f.getId().equals(id)).findFirst();
    }

    @Override
    public void save(Fita fita) {
        Optional<Fita> filmeOptional = this.findById(fita.getId());
        if(filmeOptional.isPresent()){
            Fita filmeCarregado = filmeOptional.get();
            filmeCarregado.setLocado(fita.isLocado());

        }else{
            fitas.add(fita);
        }
    }

    @Override
    public void delete(Fita fita) {
        fitas.remove(fita);
    }
}
