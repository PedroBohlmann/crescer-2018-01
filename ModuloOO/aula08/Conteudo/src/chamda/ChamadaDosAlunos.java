package chamda;

import java.util.HashMap;
import java.util.Map;

public class ChamadaDosAlunos {

    private Map<Integer,String> listaDeChamada;//importar do util

    public ChamadaDosAlunos() {
        listaDeChamada = new HashMap<>();
        this.listaDeChamada.put(1,"Kakaroto");
        this.listaDeChamada.put(2,"Vegeta");
    }

    public Map<Integer, String> getListaDeChamada() {
        return listaDeChamada;
    }
}
