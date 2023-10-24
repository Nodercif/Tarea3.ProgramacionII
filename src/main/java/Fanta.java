/**
 * La clase Fanta genera una bebida de tipo Fanta.
 **/
public class Fanta extends Bebida{
    /**
     * Mediante el constructor de Fanta se le asigna un número de serie a la bebida.
     **/
    public Fanta(int serie){
        super(serie);
    }
    /**
     * Método beber:
     * @return entrega una brebe descripción del sabor de la bebida.
     **/
    public String beber(){
        return "Fanta\nSabor: Naranja, dulce";
    }
}
