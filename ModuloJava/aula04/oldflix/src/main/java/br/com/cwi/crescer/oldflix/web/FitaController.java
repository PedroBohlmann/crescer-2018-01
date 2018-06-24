package br.com.cwi.crescer.oldflix.web;

import br.com.cwi.crescer.oldflix.dominio.Fita;
import br.com.cwi.crescer.oldflix.service.fita.*;
import br.com.cwi.crescer.oldflix.web.model.Response.FilmeSemFitasResponse;
import br.com.cwi.crescer.oldflix.web.model.Response.FitaComFilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/fita")
@RestController
public class FitaController {

    @Autowired
    private SalvaFitaService salvaFitaService;

    @Autowired
    private ListarFitasService listarFitasService;

    @Autowired
    private BuscarFitaPorIdService buscarFitaPorIdService;

    @Autowired
    private DeletarFitaPorIdService deletarFitaPorIdService;

    @Autowired
    private AtualizarFitaService atualizarFitaService;

    @GetMapping()
    public List<FitaComFilmeResponse> listar(){
        List<Fita> fitas = listarFitasService.listar();
        List<FitaComFilmeResponse> fitasParaRetorno = new ArrayList<>();

        for(Fita fitaAtual:fitas){
            fitasParaRetorno.add(mapearFitaParaReponse(fitaAtual));
        }

        return fitasParaRetorno;
    }

    @GetMapping("/{id}")
    public FitaComFilmeResponse buscarPorId(@PathVariable("id")Long id){
        Fita fitaCarregada =  buscarFitaPorIdService.buscar(id);

        return mapearFitaParaReponse(fitaCarregada);
    }

    @PostMapping("/filme/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFita(@PathVariable("id")Long idFilme,@RequestBody Fita fita){
        salvaFitaService.salvar(idFilme,fita);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarId(@PathVariable("id")Long id){
        deletarFitaPorIdService.deletar(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FitaComFilmeResponse atualizaFita(@PathVariable("id")Long id, @RequestBody Fita fita){
        atualizarFitaService.atualizar(id,fita);

        return mapearFitaParaReponse(buscarFitaPorIdService.buscar(id));
    }

    private FitaComFilmeResponse mapearFitaParaReponse(Fita fita){
        FilmeSemFitasResponse filmeSemFitasResponse = FilmeSemFitasResponse
                .builder()
                .id(fita.getFilme().getId())
                .titulo(fita.getFilme().getTitulo())
                .categoria(fita.getFilme().getCategoria())
                .prazoEntrega(fita.getFilme().getPrazoEntrega())
                .valor(fita.getFilme().getValor())
                .build();

        return FitaComFilmeResponse
                .builder()
                .id(fita.getId())
                .filme(filmeSemFitasResponse)
                .locado(fita.isLocado())
                .build();
    }
}
