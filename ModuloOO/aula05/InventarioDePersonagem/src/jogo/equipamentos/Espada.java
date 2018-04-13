package jogo.equipamentos;

public class Espada extends Equipamento {
    public Espada(){
        super("Espada", 80, 6.5, 60);
    }

    @Override
    protected int getUsoDeDurabilidade() {
        return 5;
    }
}
