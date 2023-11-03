package programa;

/**
 * La clase programa.Snicker genera un dulce de tipo programa.Snicker.
 **/
public class Snicker extends Dulce{
    /**
     * Mediante el constructor de programa.Snicker se le asigna un número de serie al dulce.
     **/
    public Snicker(){
        super();
    }
    /**
     * Método comer:
     * @return entrega una brebe descripción del sabor del dulce.
     **/
    public String comer(){
        return "Snicker\nSabor: Caramelo - maní bañado en chocolate, dulce";
    }

}
