package programa;

/**
 * La clase programa.Super8 genera un dulce de tipo programa.Super8.
 **/
public class Super8 extends Dulce {
    /**
     * Mediante el constructor de programa.Super8 se le asigna un número de serie al dulce.
     **/
    public Super8(){
        super();
    }
    /**
     * Método comer:
     * @return entrega una brebe descripción del sabor del dulce.
     **/
    public String comer(){
        return "Super8\nSabor: Galleta bañada en chocolate, dulce";
    }
}
