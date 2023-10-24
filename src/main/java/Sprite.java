/**
 * La clase Sprite genera una bebida de tipo Sprite.
 **/
class Sprite extends Bebida{
    /**
     * Mediante el constructor de Sprite se le asigna un número de serie a la bebida.
     **/
    public Sprite(int serie){
        super(serie);
    }
    /**
     * Método beber:
     * @return entrega una brebe descripción del sabor de la bebida.
     **/
    public String beber(){
        return "Sprite.\nSabor: Limón, dulce";
    }
}