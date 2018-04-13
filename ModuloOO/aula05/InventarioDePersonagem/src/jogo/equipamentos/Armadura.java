package jogo.equipamentos;

public class Armadura extends Equipamento {
    public Armadura() {
        super("Armadura", 120, 15,100);
    }

    @Override
    protected int getUsoDeDurabilidade() {
        return 10;
    }
}
