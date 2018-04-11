public class AnaoGuerreiro {
    private int vida;
    private int bonusDeAtaque;
    private Machado machadoEquipado;

    public AnaoGuerreiro() {
        this.vida = 20;
        this.bonusDeAtaque = 7;
    }
    public void equiparMachado(Machado machado){
        if(podeEquiparMachado(machado)) {
            this.machadoEquipado = machado;
        }
    }
    private boolean podeEquiparMachado(Machado machado) {
        if(machado ==null){ return false; }
        return machado.getPoderDoMachado()>=10;
    }
    public Machado getMachadoEquipado() {
        return machadoEquipado;
    }
    public int getPoderDeAtaque(){
        int poderDeMachado=machadoEquipado!=null? machadoEquipado.getPoderDoMachado() : 0;
        return (bonusDeAtaque+poderDeMachado);
    }
    public void desequiparMachado(){
        this.machadoEquipado=null;
    }
}
