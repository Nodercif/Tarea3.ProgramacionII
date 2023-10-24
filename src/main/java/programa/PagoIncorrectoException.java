package programa;

/**
 * Excepcion para cuando la moneda ingresada es incorrecta.
 **/
public class PagoIncorrectoException extends Exception{
    public PagoIncorrectoException(String mensaje){
        super(mensaje);
    }
}
