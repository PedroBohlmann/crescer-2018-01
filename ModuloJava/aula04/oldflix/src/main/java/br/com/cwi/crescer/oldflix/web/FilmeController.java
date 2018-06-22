package br.com.cwi.crescer.oldflix.web;

import br.com.cwi.crescer.oldflix.dominio.Categoria;
import br.com.cwi.crescer.oldflix.dominio.Filme;
import br.com.cwi.crescer.oldflix.dominio.repository.IFilmeRepository;
import br.com.cwi.crescer.oldflix.exception.FilmeNaoCadastrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/filme")
@RestController
public class FilmeController {

    @Autowired
    private IFilmeRepository repository;

    @GetMapping()
    public List<Filme> listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Filme buscarPorId(@PathVariable("id")Long id){
        return repository.findById(id).orElseThrow(()->new FilmeNaoCadastrado(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody Filme filme){
        repository.save(filme);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarId(@PathVariable("id")Long id){
        Filme filme = repository.findById(id).orElseThrow(()->new FilmeNaoCadastrado(id));

        repository.delete(filme);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Filme atualizaFilme(@PathVariable("id")Long id,@RequestBody Filme filme){
        repository.save(filme);

        return repository.findById(id).orElseThrow(()->new FilmeNaoCadastrado(id));
    }
}
