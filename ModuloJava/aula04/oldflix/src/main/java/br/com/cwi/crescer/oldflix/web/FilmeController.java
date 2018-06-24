package br.com.cwi.crescer.oldflix.web;

import br.com.cwi.crescer.oldflix.dominio.Filme;
import br.com.cwi.crescer.oldflix.dominio.Fita;
import br.com.cwi.crescer.oldflix.service.filme.*;
import br.com.cwi.crescer.oldflix.web.model.Request.FilmeRequest;
import br.com.cwi.crescer.oldflix.web.model.Response.FilmeResponse;
import br.com.cwi.crescer.oldflix.web.model.Response.FitaSemFilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/filme")
@RestController
public class FilmeController {

    @Autowired
    private ListarFilmesService listarFilmesService;

    @Autowired
    private BuscarFilmePorIdService buscarFilmePorIdService;

    @Autowired
    private CriarNovoFilmeService criarNovoFilmeService;

    @Autowired
    private DeletarFilmePorIdService deletarFilmePorIdService;

    @Autowired
    private AtualizarFilmePorIdService atualizarFilmePorIdService;

    @GetMapping()
    public List<FilmeResponse> listar(){
        List<Filme> listaDeFilmes = listarFilmesService.listar();

        List<FilmeResponse> filmeResponses = new ArrayList<>();

        for(Filme filmeAtual: listaDeFilmes){
            filmeResponses.add(mapearFilmeParaFilmeResponse(filmeAtual));
        }

        return filmeResponses;
    }

    @GetMapping("/{id}")
    public FilmeResponse buscarPorId(@PathVariable("id")Long id){
        Filme filmeCarregado = buscarFilmePorIdService.buscar(id);

        return mapearFilmeParaFilmeResponse(filmeCarregado);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody FilmeRequest filmeRequest){
        Filme filme = mapearFilmeRequestParaFilme(filmeRequest);

        criarNovoFilmeService.criar(filme);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarId(@PathVariable("id")Long id){
        deletarFilmePorIdService.deletar(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FilmeResponse atualizaFilme(@PathVariable("id")Long id, @RequestBody FilmeRequest filmeRequest){
        Filme filme = mapearFilmeRequestParaFilme(filmeRequest);

        atualizarFilmePorIdService.atualizar(id,filme);

        Filme filmeCarregado = buscarFilmePorIdService.buscar(id);

        return mapearFilmeParaFilmeResponse(filmeCarregado);
    }

    private FilmeResponse mapearFilmeParaFilmeResponse(Filme filme) {
        List<FitaSemFilmeResponse> fitas = new ArrayList<>();

        for (Fita fitaAtual : filme.getFitas()) {
            FitaSemFilmeResponse fitaNova = FitaSemFilmeResponse.
                    builder()
                    .id(fitaAtual.getId())
                    .locado(fitaAtual.isLocado())
                    .build();
            fitas.add(fitaNova);
        }
        return FilmeResponse
                .builder()
                .id(filme.getId())
                .titulo(filme.getTitulo())
                .categoria(filme.getCategoria())
                .prazoEntrega(filme.getPrazoEntrega())
                .valor(filme.getValor())
                .fitas(fitas).build();
    }

    private Filme mapearFilmeRequestParaFilme(FilmeRequest filmeRequest){
        return new Filme(filmeRequest.getId(),filmeRequest.getTitulo(),filmeRequest.getCategoria());
    }
}
