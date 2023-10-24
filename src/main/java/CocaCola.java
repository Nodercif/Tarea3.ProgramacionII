/**
 * La clase CocaCola genera una bebida de tipo Coca-Cola.
 * */
class CocaCola extends Bebida{
    /**
     * Mediante el constructor de CocaCola se le asigna un número de serie a la bebida.
     * */
    public CocaCola(int serie){
        super(serie);
    }
    /**
     * Método beber:
     * @return entrega una brebe descripción del sabor de la bebida.
     * */
    public String beber(){
        return "CocaCola\nSabor: Vainilla, dulce";
    }
}