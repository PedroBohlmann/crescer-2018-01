package jogo;

public class Item {
    private String nome;
    private double valor;
    private double peso;

    private InventarioDeItens inventarioDeItensAquePertence;

    public Item(String nome, double valor, double peso) {
        this.nome = nome;
        this.valor = valor;
        this.peso = peso;
    }
    public boolean estaEmUmInventario(){
        return this.inventarioDeItensAquePertence!=null;
    }
    public String getNome(){
        return nome;
    }

    public void vincularAInventario(InventarioDeItens inventarioDeItens){
        this.inventarioDeItensAquePertence=inventarioDeItens;
    }

    public InventarioDeItens getInventarioDeItensAquePertence() {
        return inventarioDeItensAquePertence;
    }

    public double getPeso() {
        return peso;
    }

    public double getValor() {
        return valor;
    }
}
