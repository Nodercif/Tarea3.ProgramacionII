package programa;

/**
 * La clase programa.Producto es abstracta y de ella salen los dos tipos de productos que contiene la máquina:
 * Bebidas y Dulces.
 **/
public abstract class Producto {
    static private int cantProductos;
    private int serie;
    public Producto(){
        cantProductos++;
        cantProductos = cantProductos%999999999;
        this.serie = cantProductos;
    }
    public int getSerie(){
        return serie;
    }
}
