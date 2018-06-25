package br.com.cwi.crescer.oldflix.service.pedido;

import br.com.cwi.crescer.oldflix.dominio.Pedido;
import br.com.cwi.crescer.oldflix.dominio.repository.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SalvaPedidoService {

    @Autowired
    private IPedidoRepository repository;

    public void salvar(Pedido pedido){
     repository.save(pedido);
    }
}
