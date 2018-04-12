package aula2;
public class Auxiliar {
    String prefix;
    String sufix;

    String addPrefixToText(String text){
        StringBuilder constructor=new StringBuilder();
        constructor.append(prefix);
        constructor.append(text);
        return constructor.toString();
    }
    String addSufixToText(String text){
        StringBuilder constructor=new StringBuilder();
        constructor.append(text);
        constructor.append(sufix);
        return constructor.toString();
    }

    String addPrefixAndSufixToText(String text) {
        StringBuilder constructor = new StringBuilder();
        constructor.append(prefix);
        constructor.append(text);
        constructor.append(sufix);
        return constructor.toString();
    }
    void setPrefix(String newPrefix){
        prefix=newPrefix;
    }
    void setSufix(String newSufix){
        sufix=newSufix;
    }

    void setPrefixAndSufix(String newPrefix,String newSufix){
        sufix=newSufix;
        prefix=newPrefix;
    }
}
