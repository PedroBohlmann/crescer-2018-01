package br.com.cwi.crescer.oldflix.repository.memory;

import br.com.cwi.crescer.oldflix.dominio.Filme;
import br.com.cwi.crescer.oldflix.dominio.repository.IFilmeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryFilmeRepository implements IFilmeRepository {

    private List<Filme> filmes = new ArrayList<>();

    @Override
    public List<Filme> findAll() {
        return filmes;
    }

    @Override
    public Optional<Filme> findById(Long id) {
        return filmes.stream().filter(f->f.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Filme> findFilmeByTitulo(String titulo) {
        return Optional.empty();
    }

    @Override
    public void save(Filme filme) {
        Optional<Filme> filmeOptional = this.findById(filme.getId());
        if(filmeOptional.isPresent()){
            Filme filmeCarregado = filmeOptional.get();
            filmeCarregado.atualizaDados(filme);

        }else{
            filmes.add(filme);
        }
    }

    @Override
    public void delete(Filme filme) {
        filmes.remove(filme);
    }
}
