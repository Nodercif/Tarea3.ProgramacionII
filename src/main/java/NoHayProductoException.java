/**
 * Excepcion para cuando no queda producto en la máquina expendedora.
 **/
public class NoHayProductoException extends Exception {
    public NoHayProductoException(String mensaje){
        super(mensaje);
    }
}
