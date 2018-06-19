package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Builder
@Getter
public class Pedido {
    private int idPedido;
    private Cliente cliente;
    @Singular
    private List<Fita> fitas;

    public void adicionaFita(Fita fita){
        fitas.add(fita);
    }
}
