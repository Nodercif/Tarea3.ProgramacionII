package programa;

/**
 * La clase programa.Bebida es la encargada de generar el producto de tipo bebida junto a un número de serie
 * que servirá para ser guardada en el respectivo depósito del expendedor.
 * Ésta clase es abstracta y de ella salen 3 tipos de bebidas: Coca-Cola, programa.Sprite y programa.Fanta.
 **/
public abstract class Bebida extends Producto{
    /**
     * El contructor es el encargado de asignar el número de serie a la bebida.
     **/
    public Bebida(){
        super();
    }
    public abstract String beber();
}