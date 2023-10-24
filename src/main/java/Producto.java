/**
 * La clase Producto es abstracta y de ella salen los dos tipos de productos que contiene la máquina:
 * Bebidas y Dulces.
 **/
abstract class Producto {
    private int serie;
    public Producto(int serie){
        this.serie = serie;
    }
    public int getSerie(){
        return serie;
    }
}
