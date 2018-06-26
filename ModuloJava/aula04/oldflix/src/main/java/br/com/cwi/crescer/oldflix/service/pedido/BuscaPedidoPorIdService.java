package br.com.cwi.crescer.oldflix.service.pedido;

import br.com.cwi.crescer.oldflix.dominio.Pedido;
import br.com.cwi.crescer.oldflix.dominio.repository.IPedidoRepository;
import br.com.cwi.crescer.oldflix.exception.PedidoNaoCadastrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class BuscaPedidoPorIdService {
    @Autowired
    private IPedidoRepository repository;

    public Pedido buscar(Long id){
        if(Objects.isNull(id)){
            throw new IllegalArgumentException("id invalido");
        }

        return repository
                .findById(id)
                .orElseThrow(()->new PedidoNaoCadastrado(id));
    }
}
