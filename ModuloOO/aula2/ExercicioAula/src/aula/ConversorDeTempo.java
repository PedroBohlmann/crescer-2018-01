package aula;

public class ConversorDeTempo {
    String formatMin(int minutes){
        StringBuilder construtorDeString=new StringBuilder();
        int hours=minToHour(minutes);
        minutes=removeHours(minutes);

        construtorDeString.append(hours);
        construtorDeString.append(" hora(s) e ");
        construtorDeString.append(minutes);
        construtorDeString.append(" minuto(s)");
        return construtorDeString.toString();
    }

    int minToHour(int minutes){
        Calculadora calc=new Calculadora();
        return (int)calc.dividir(minutes,60);
    }

    int removeHours(int minutes){
        Calculadora calc=new Calculadora();
        int hours=minToHour(minutes);
        return calc.subtrair(minutes,(int)calc.multiplicar(hours,60));
    }
}
