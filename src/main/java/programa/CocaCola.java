package programa;

/**
 * La clase programa.CocaCola genera una bebida de tipo Coca-Cola.
 * */
public class CocaCola extends Bebida{
    /**
     * Mediante el constructor de programa.CocaCola se le asigna un número de serie a la bebida.
     * */
    public CocaCola(){
        super();
    }
    /**
     * Método beber:
     * @return entrega una brebe descripción del sabor de la bebida.
     * */
    public String beber(){
        return "CocaCola\nSabor: Vainilla, dulce";
    }
}