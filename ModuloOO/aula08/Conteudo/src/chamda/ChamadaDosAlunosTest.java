package chamda;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChamadaDosAlunosTest {

    @Test
    public void test(){
        ChamadaDosAlunos chamadaDosAlunos= new ChamadaDosAlunos();
        Map<Integer, String> listaDeChamada= chamadaDosAlunos.getListaDeChamada();

        assertTrue(true);
    }
}
