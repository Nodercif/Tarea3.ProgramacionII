package programa;

/**
 * La clase programa.Moneda es la encargada de generar las monedas que se pueden utilizar.
 * Ésta clase es abstracta y de ella salen 4 valores de monedas: $100, $500, $1000 y $1500.
 **/
public abstract class Moneda implements Comparable<Moneda>{
    static private int cantMonedas;
    private int serie;
    public Moneda(){
        cantMonedas++;
        cantMonedas = cantMonedas%999999999;
        this.serie = cantMonedas;
    }
    public int getSerie(){
        return this.serie;
    }
    /**
     * Método compareTo:
     * En éste método se compara una moneda con otra.
     * @param moneda es la moneda que se comparará.
     * @return entrega positivo si la otra moneda es menor, negativo si es mayor y 0 si son iguales.
     */
    @Override
    public int compareTo(Moneda moneda) {
        return this.getValor()-moneda.getValor();
    }
    public abstract int getValor();
}