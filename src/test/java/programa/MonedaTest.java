package programa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonedaTest {
    @Test
    void serie(){
        Moneda m1 = new Moneda1000();
        Moneda m2 = new Moneda100();
        Assertions.assertNotEquals(m1.getSerie(),m2.getSerie());
    }
    @Test
    void moneda500MayorQue100(){
        Moneda m100 = new Moneda100();
        Moneda m500 = new Moneda500();
        assertTrue(m500.compareTo(m100)>0);
    }
    @Test
    void moneda1000MenorQue1500(){
        Moneda m1000 = new Moneda100();
        Moneda m1500 = new Moneda500();
        assertTrue(m1000.compareTo(m1500)<0);
    }
    @Test
    void monedasDelMismoValor(){
        Moneda m1 = new Moneda500();
        Moneda m2 = new Moneda500();
        Assertions.assertEquals(0, m1.compareTo(m2));
    }
}