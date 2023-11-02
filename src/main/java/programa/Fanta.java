package programa;

/**
 * La clase programa.Fanta genera una bebida de tipo programa.Fanta.
 **/
public class Fanta extends Bebida{
    /**
     * Mediante el constructor de programa.Fanta se le asigna un número de serie a la bebida.
     **/
    public Fanta(){
        super();
    }
    /**
     * Método beber:
     * @return entrega una brebe descripción del sabor de la bebida.
     **/
    public String beber(){
        return "Fanta\nSabor: Naranja, dulce";
    }
}
