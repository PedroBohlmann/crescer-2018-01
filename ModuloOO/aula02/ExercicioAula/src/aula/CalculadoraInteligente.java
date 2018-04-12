package aula;

public class CalculadoraInteligente {
    String apresentarSomar(Calculadora calc, Auxiliar auxiliar, int x,int y){
        int resultado = calc.somar(x,y);
        return auxiliar.addPrefixAndSufixToText(String.valueOf(resultado));
    }
    String apresentarSubtracao(Calculadora calc, Auxiliar auxiliar, int x,int y){
        int resultado = calc.subtrair(x,y);
        return auxiliar.addPrefixAndSufixToText(String.valueOf(resultado));
    }
    String apresentarDivisao(Calculadora calc, Auxiliar auxiliar, int x,int y){
        double resultado = calc.dividir(x,y);
        return auxiliar.addPrefixAndSufixToText(String.valueOf(resultado));
    }
    String apresentarMultiplicacao(Calculadora calc, Auxiliar auxiliar, int x,int y){
        double resultado = calc.multiplicar(x,y);
        return auxiliar.addPrefixAndSufixToText(String.valueOf(resultado));
    }

}
