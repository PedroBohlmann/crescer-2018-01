package models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private List<Fita> fitas;
    private double valorTotal;

    public Pedido(int idPedido, Cliente cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.fitas = new ArrayList<>();
        this.valorTotal = 0;
    }

    public void adicionaFita(Fita fita) {
        fitas.add(fita);
        fita.loca();
        calcularValorTotal();
    }

    public void calcularValorTotal() {
        this.valorTotal = 0;
        for (Fita fita : fitas) {
            this.valorTotal += fita.getValor();
        }
    }

    public void removeFita(Fita fita){
        fitas.remove(fita);
        fita.entrega();
        calcularValorTotal();
    }
}
