public class AnaoFerreiro {
    private int idade;
    private int nivel;

    public AnaoFerreiro(int idade, int nivel) {
        this.idade = idade;
        this.nivel = nivel;
    }

    public int getIdade() {
        return idade;
    }

    public int getNivel() {
        return nivel;
    }

    public Machado forjaMachado(){
        int poderMachado=0;
        if(idade>=100&&idade<=200){
            poderMachado+=2;
        }
        poderMachado+=nivel;
        if (poderMachado>20){
            return new Machado(20);
        }else{
            return new Machado(poderMachado);
        }
    }
    public void melhoraMachado(Machado machado){
        if(machado==null){
            return;
        }
        if(idade>150&&nivel>=5){
            if(nivel>=6&&nivel<=10){
                machado.melhoraMachado(2);
            }
            else if(nivel>10){
                machado.melhoraMachado(3);
            }
        }
    }
}