/**
 * Excepcion para cuando la moneda ingresada no es suficiente.
 **/
public class PagoInsuficienteException extends Exception{
    public PagoInsuficienteException(String mensaje){
        super(mensaje);
    }
}
