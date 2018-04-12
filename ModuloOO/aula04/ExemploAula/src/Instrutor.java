public class Instrutor extends Colaborador {
    private int numeroPis;

    public Instrutor(String nome, int numeroPis) {
        super(nome);
        this.numeroPis = numeroPis;
    }
    @Override
    public String retornarString(){
        return "Eu sou o instrutor "+super.getNome();
    }
}
