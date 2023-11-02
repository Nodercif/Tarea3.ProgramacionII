package programa;

/**
 * La clase programa.Expendedor muestra el funcionamiento de la máquina expendedora.
 **/
public class Expendedor {
    private Producto producto;
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Bebida> fanta;
    private Deposito<Dulce> snicker;
    private Deposito<Dulce> super8;
    private Deposito<Moneda> monVuelto;

    private Deposito<Moneda> depositoMonedas;

    /**
     * El constructor de programa.Expendedor recibe la cantidad de productos que tendrán las bebidas y ducles de cada tipo.
     * @param numProducto es la cantidad de productos, con ella se inicializan los depositos de cada uno.
     **/
    public Expendedor(int numProducto) {
        coca = new Deposito<Bebida>();
        sprite = new Deposito<Bebida>();
        fanta = new Deposito<Bebida>();
        snicker = new Deposito<Dulce>();
        super8 = new Deposito<Dulce>();
        monVuelto = new Deposito<Moneda>();
        depositoMonedas = new Deposito<Moneda>();
        for (int i = 0; i < numProducto; i++) {
                coca.addElemento(new CocaCola(i));
                sprite.addElemento(new Sprite(i));
                fanta.addElemento(new Fanta(i));
                snicker.addElemento(new Snicker(i));
                super8.addElemento(new Super8(i));
        }
    }

    /**
     * El método comprarProducto realiza la compra del producto y revisa cada caso posible según la moneda que se
     * le ingresa y según el producto que se pide.
     * @param moneda es la moneda que fue ingresada en la máquina.
     * @param seleccionProducto es el tipo de producto que se pidió.
     * @return devuelve el prodcuto que se obtuvo de la máquina, este puede ser de tipo bebida o dulce.
     * @throws NoHayProductoException ocurre cuando a la máquina no le queda el producto que se trata de comprar.
     * @throws PagoInsuficienteException la moneda que se inserta no es suficiente para comprar el producto.
     * @throws PagoIncorrectoException se le paso una moneda nula, no hay moneda.
     **/
    public void comprarProducto(Moneda moneda, SeleccionProducto seleccionProducto) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        //verificar que se inserto moneda
        if(moneda == null){
            throw new PagoIncorrectoException("Pago incorrecto.");
        }
        //verificar que el valor de la moneda es sufciente para comprar el producto seleccionado
        int valorMoneda = moneda.getValor();
        if (valorMoneda < seleccionProducto.getPrecio()) {
            monVuelto.addElemento(moneda);
            throw new PagoInsuficienteException("Pago insuficiente.");
        }
        //se trata de dispensar el producto seleccionado a producto
        producto = null;
        switch (seleccionProducto) {
            case COCA_COLA:
                producto = coca.getElemento();
                break;
            case SPRITE:
                producto = sprite.getElemento();
                break;
            case FANTA:
                producto = fanta.getElemento();
                break;
            case SNICKER:
                producto = snicker.getElemento();
                break;
            case SUPER8:
                producto = super8.getElemento();
        }

        if(producto != null) {
            //sí si se logra dispensar el producto (hay suficiente en el deposito)
            //se guarda la moneda que se uso de pago en el deposito de monedas
            depositoMonedas.addElemento(moneda);
            //poner vuelto en monedas de 100 en el deposito de vuelto monVuelto
            int vuelto = valorMoneda-seleccionProducto.getPrecio();
            while(vuelto > 0){
                monVuelto.addElemento(new Moneda100());
                vuelto -= 100;
            }

        }
        else{
            monVuelto.addElemento(moneda);
            throw new NoHayProductoException("No hay producto.");
        }
    }

    /**
     * Método getVuelto:
     * @return Saca una de las monedas de 100$ que se dispensaron como vuelto.
     */
    public Moneda getVuelto(){
        return monVuelto.getElemento();
    }
    /**
     * Método getProducto
     * @return Saca el producto comprado de el receptaculo
     */
    public Producto getProducto(){
        Producto ret = producto;
        producto = null;
        return ret;
    }
}
