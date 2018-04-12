public class Crescer extends Colaborador  {
    private int nota;

    public Crescer(String nome, int nota) {
        super(nome);
        this.nota = nota;
    }
    @Override
    public String retornarString(){
        return "Eu sou o Crescer "+super.getNome();
    }
}
