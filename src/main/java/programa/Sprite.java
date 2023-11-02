package programa;

/**
 * La clase programa.Sprite genera una bebida de tipo programa.Sprite.
 **/
class Sprite extends Bebida{
    /**
     * Mediante el constructor de programa.Sprite se le asigna un número de serie a la bebida.
     **/
    public Sprite(){
        super();
    }
    /**
     * Método beber:
     * @return entrega una brebe descripción del sabor de la bebida.
     **/
    public String beber(){
        return "Sprite.\nSabor: Limón, dulce";
    }
}