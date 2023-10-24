/**
 * La clase Super8 genera un dulce de tipo Super8.
 **/
public class Super8 extends Dulce {
    /**
     * Mediante el constructor de Super8 se le asigna un número de serie al dulce.
     **/
    public Super8(int serie){
        super(serie);
    }
    /**
     * Método comer:
     * @return entrega una brebe descripción del sabor del dulce.
     **/
    public String comer(){
        return "Super8\nSabor: Galleta bañada en chocolate, dulce";
    }
}
