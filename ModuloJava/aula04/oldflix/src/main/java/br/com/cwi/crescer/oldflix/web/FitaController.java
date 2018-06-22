package br.com.cwi.crescer.oldflix.web;


import br.com.cwi.crescer.oldflix.dominio.Fita;
import br.com.cwi.crescer.oldflix.dominio.repository.IFitaRepository;
import br.com.cwi.crescer.oldflix.exception.FitaNaoCadastrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/fita")
@RestController
public class FitaController {

    @Autowired
    private IFitaRepository repository;

    @GetMapping()
    public List<Fita> listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Fita buscarPorId(@PathVariable("id")Long id){
        return repository.findById(id).orElseThrow(()->new FitaNaoCadastrada(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFita(@RequestBody Fita fita){
        repository.save(fita);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarId(@PathVariable("id")Long id){
        Fita fita = repository.findById(id).orElseThrow(()->new FitaNaoCadastrada(id));

        repository.delete(fita);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Fita atualizaFita(@PathVariable("id")Long id,@RequestBody Fita fita){
        repository.save(fita);

        return repository.findById(id).orElseThrow(()->new FitaNaoCadastrada(id));
    }
}
