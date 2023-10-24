/**
 * La clase Snicker genera un dulce de tipo Snicker.
 **/
public class Snicker extends Dulce{
    /**
     * Mediante el constructor de Snicker se le asigna un número de serie al dulce.
     **/
    public Snicker(int serie){
        super(serie);
    }
    /**
     * Método comer:
     * @return entrega una brebe descripción del sabor del dulce.
     **/
    public String comer(){
        return "Snicker\nSabor: Caramelo - maní bañado en chocolate, dulce";
    }

}
