package aula2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuxiliarTest {
    @Test
    void testAddPrefixToBond(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        String text="Bond";
        String prefix="James ";
        auxiliar.setPrefix(prefix);
        String expected = "James Bond";
        //Act
        String result=auxiliar.addPrefixToText(text);
        //Assert
        assertEquals(expected,result);
    }
    @Test
    void testAddPrefixToPickles(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        String text="Pickles";
        String prefix="Mr.";
        String expected = "Mr.Pickles";
        auxiliar.setPrefix(prefix);
        //Act
        String result=auxiliar.addPrefixToText(text);
        //Assert
        assertEquals(expected,result);
    }
    @Test
    void testAddPrefixToSmith(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        String text="Smith";
        String prefix="Mrs.";
        String expected = "Mrs.Smith";
        auxiliar.setPrefix(prefix);
        //Act
        String result=auxiliar.addPrefixToText(text);
        //Assert
        assertEquals(expected,result);
    }
    //Sufix
    @Test
    void testAddSufixToHelp(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        String text="help";
        String sufix="ful";
        String expected = "helpful";
        auxiliar.setSufix(sufix);
        //Act
        String result=auxiliar.addSufixToText(text);
        //Assert
        assertEquals(expected,result);
    }
    @Test
    void testAddSufixToGit(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        String text="git";
        String sufix=" log";
        String expected = "git log";
        auxiliar.setSufix(sufix);
        //Act
        String result=auxiliar.addSufixToText(text);
        //Assert
        assertEquals(expected,result);
    }
    @Test
    void testAddSufixToLs(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        String text="ls";
        String sufix=" -la";
        String expected = "ls -la";
        auxiliar.setSufix(sufix);
        //Act
        String result=auxiliar.addSufixToText(text);
        //Assert
        assertEquals(expected,result);
    }
    //Prefix and Sufix
    @Test
    void testAddPrefixToCommitAndSufix(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        String prefix="git commit -m '";
        String text="Send help";
        String sufix="'";
        String expected = "git commit -m 'Send help'";
        auxiliar.setPrefixAndSufix(prefix,sufix);
        //Act
        String result=auxiliar.addPrefixAndSufixToText(text);
        //Assert
        assertEquals(expected,result);
    }
    @Test
    void testAddPrefixToSendHelpAndSufix(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        String prefix="Call 911 and ";
        String text="SEND HELP";
        String sufix="!!!";
        String expected = "Call 911 and SEND HELP!!!";
        auxiliar.setPrefixAndSufix(prefix,sufix);
        //Act
        String result=auxiliar.addPrefixAndSufixToText(text);
        //Assert
        assertEquals(expected,result);
    }

    @Test
    void testAddPrefixToLogAndSufix(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        String prefix="git ";
        String text="log";
        String sufix=" -stat";
        String expected = "git log -stat";
        auxiliar.setPrefixAndSufix(prefix,sufix);
        //Act
        String result=auxiliar.addPrefixAndSufixToText(text);
        //Assert
        assertEquals(expected,result);
    }
}