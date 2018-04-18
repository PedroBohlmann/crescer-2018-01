package arma;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArmaTest {
    @Test
    public void atirarComArmaPerde1Municao(){
        Arma arma=new Arma();

        try {
            arma.atirar();

            assertTrue(true);
        } catch (SemMunicaoExtraException e) {
            //Nao tem municao
            assertTrue(false);
        } catch (Exception ex){
            assertTrue(false);
            //qualquer excecao que nao seja ArmaSemMunicaoException
        } finally {
            //Sempre é executado
        }
    }

    @Test
    public void testaAtirarSubindoPraJUnit() throws SemMunicaoExtraException {
        Arma arma = new Arma();

        arma.atirar();
    }

    @Test
    public void armaSemMunicao(){
        Arma arma=new Arma();
        //Usando Closure
        assertThrows(SemMunicaoExtraException.class,()->{//Aqui comeca a closure
            for(int i =0;i<40;i++){
                arma.atirar();
            }
        });

        //AssertThrows tem dois parametros excecao que teoricamente vai dar e a closure que seria um cria metodo na corrida
    }

    @Test
    public void atira7BalasTemMunicaoExtra() throws SemMunicaoExtraException {

        Arma arma =new Arma();
        for(int i=0;i<7;i++){
            arma.atirar();
        }
    }


}
