package programa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpendedorTest {
    Expendedor exp;

    @BeforeEach
    void setUp() {
        exp = new Expendedor(3);
    }
    @Test
    void comprarSnickers() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Producto snick = exp.comprarProducto(new Moneda1500(), SeleccionProducto.SNICKER);
        assertTrue(snick instanceof Snicker);
    }
    @Test
    void comprarCoca() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Producto coc =exp.comprarProducto(new Moneda1500(), SeleccionProducto.COCA_COLA);
        assertTrue(coc instanceof CocaCola);
    }
    @Test
    void comprarSinVuelto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Producto prod = exp.comprarProducto(new Moneda100(), SeleccionProducto.COCA_COLA);
        assertNull(exp.getVuelto());
    }
    @Test
    void vueltoDe200() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Producto prod = exp.comprarProducto(new Moneda500(), SeleccionProducto.FANTA);
        Moneda v = exp.getVuelto();
        int vuelto = 0;
        while(v != null){
            vuelto += v.getValor();
            v = exp.getVuelto();
        }
        assertEquals(200,vuelto);
    }
    @Test
    void vueltoDe1300() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Producto prod = exp.comprarProducto(new Moneda1500(), SeleccionProducto.SPRITE);
        Moneda v = exp.getVuelto();
        int vuelto = 0;
        while(v != null){
            vuelto += v.getValor();
            v = exp.getVuelto();
        }
        assertEquals(1300,vuelto);
    }
    @Test
    void dineroInsuficiente() throws NoHayProductoException, PagoIncorrectoException {
        Moneda m = new Moneda100();
        try{
            Producto prod = exp.comprarProducto(m, SeleccionProducto.SUPER8);
            fail("se esperaba la excepcion programa.PagoInsuficienteException");
        }catch (PagoInsuficienteException e){
            Assertions.assertEquals(m,exp.getVuelto());
        }
    }
    @Test
    void sinProductos() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        exp.comprarProducto(new Moneda1500(), SeleccionProducto.COCA_COLA);
        exp.comprarProducto(new Moneda1500(), SeleccionProducto.COCA_COLA);
        exp.comprarProducto(new Moneda1500(), SeleccionProducto.COCA_COLA);
        while(exp.getVuelto() != null)exp.getVuelto();//vaciar el deposito de vuelto
        Moneda m = new Moneda1500();
        try{
            exp.comprarProducto(m, SeleccionProducto.COCA_COLA);
            fail("se esperaba la excepcion programa.NoHayProductoException");
        }catch(NoHayProductoException e){
            Assertions.assertEquals(m,exp.getVuelto());
        }
    }
    @Test
    void sinMoneda()throws NoHayProductoException, PagoInsuficienteException {
        try{
            exp.comprarProducto(null, SeleccionProducto.COCA_COLA);
            fail("se esperaba la excepcion programa.PagoIncorrectoException");
        }catch(PagoIncorrectoException e){
            assertNull(exp.getVuelto());
        }
    }

}