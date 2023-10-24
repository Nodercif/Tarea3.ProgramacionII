import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompradorTest {
    Comprador comprador;
    Expendedor exp;
    @BeforeEach
    void setUp() {
        exp = new Expendedor(1);
    }
    @Test
    void comprarSprite() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        comprador = new Comprador(new Moneda500(),Enumeracion.SPRITE,exp);
        assertEquals("Sprite.\nSabor: Limón, dulce",comprador.queBebiste());
    }
    @Test
    void comprarSuper8() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        comprador = new Comprador(new Moneda500(),Enumeracion.SUPER8,exp);
        assertEquals("Super8\nSabor: Galleta bañada en chocolate, dulce",comprador.queBebiste());
    }
    @Test
    void comprarSnicker() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        comprador = new Comprador(new Moneda500(),Enumeracion.SNICKER,exp);
        assertEquals("Snicker\nSabor: Caramelo - maní bañado en chocolate, dulce",comprador.queBebiste());
    }
    @Test
    void vueltoDe200() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        comprador = new Comprador(new Moneda500(),Enumeracion.FANTA,exp);
        assertEquals(200,comprador.cuantoVuelto());
    }
    @Test
    void pagoExacto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        comprador = new Comprador(new Moneda100(),Enumeracion.COCA_COLA,exp);
        assertEquals(0,comprador.cuantoVuelto());
    }
    @Test
    void sinStock() throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {
        exp.comprarProducto(new Moneda500(),Enumeracion.COCA_COLA);
        Moneda m = new Moneda500();
        try{
            comprador = new Comprador(m,Enumeracion.COCA_COLA,exp);
            fail("se esperaba la excepcion NoHayProductoException");
        }catch (NoHayProductoException ignored){}
    }
    @Test
    void pagoInsuficiente() throws PagoIncorrectoException, NoHayProductoException {
        Moneda m = new Moneda100();
        try{
            comprador = new Comprador(m,Enumeracion.SNICKER,exp);
            fail("se esperaba la excepcion PagoInsuficienteException");
        }catch (PagoInsuficienteException ignored){}

    }
    @Test
    void pagoIncorrecto() throws PagoInsuficienteException, NoHayProductoException{
        try{
            comprador = new Comprador(null,Enumeracion.SNICKER,exp);
            fail("se esperaba la excepcion PagoIncorrectoException");
        }catch (PagoIncorrectoException ignored){}
    }
}