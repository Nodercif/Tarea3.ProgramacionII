package programa;

/**
 * La clase programa.SeleccionProducto le asigna un número identificador y un precio a cada producto de la máquina expendedora.
 **/
public enum SeleccionProducto {
    COCA_COLA(1, 100),
    SPRITE(2, 200),
    FANTA(3, 300),
    SNICKER(4, 400),
    SUPER8(5, 500);
    private final int tipo;
    private final int precio;
    /**
     * El constructor recibe el tipo y precio del producto que fue escogido.
     * @param tipo es el identificador del producto.
     * @param precio es el precio del prodcuto.
     **/
    SeleccionProducto(int tipo, int precio){
        this.tipo = tipo;
        this.precio = precio;
    }
    /**
     * Método getTipo:
     * @return entrega el tipo de producto.
     **/
    public int getTipo(){
        return tipo;
    }

    /**
     * Método getPrecio:
     * @return entrega el precio del producto.
     **/
    public int getPrecio(){
        return precio;
    }
}
