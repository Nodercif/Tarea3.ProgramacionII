import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositoTest {
    @Test
    void añadir3intsYQuitar1(){
        Deposito<Integer> depo = new Deposito<>();
        depo.addElemento(3);
        depo.addElemento(2);
        depo.addElemento(5);
        assertEquals(3,depo.getElemento());
    }
    @Test
    void quedarseSinElementos(){
        Deposito<String> depo = new Deposito<>();
        depo.addElemento("baba");
        depo.getElemento();
        assertNull(depo.getElemento());
    }
    @Test
    void depositoVacio(){
        Deposito<String> depo = new Deposito<>();
        assertNull(depo.getElemento());
    }
}