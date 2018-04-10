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

    String formatSec(int seconds){
        StringBuilder construtorDeString=new StringBuilder();
        int hours = secToHour(seconds);
        int minutes = secToMinutes(seconds);

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
    int secToHour(int seconds){
        Calculadora calc=new Calculadora();
        int minutes=(int)calc.dividir(seconds,60);
        int hours=minToHour(minutes);
        return hours;
    }
    int secToMinutes(int seconds){
        Calculadora calc=new Calculadora();
        int minutes=(int)calc.dividir(seconds,60);
        return removeHours(minutes);
    }
}
