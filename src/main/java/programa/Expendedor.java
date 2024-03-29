package programa;

/**
 * La clase programa.Expendedor muestra el funcionamiento de la máquina expendedora.
 **/
public class Expendedor {
    public Deposito<Producto> productosComprados;
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snicker;
    private Deposito<Producto> super8;
    private Deposito<Moneda> monVuelto;

    private Deposito<Moneda> depositoMonedas;

    /**
     * El constructor de programa.Expendedor recibe la cantidad de productos que tendrán las bebidas y ducles de cada tipo.
     * @param numProducto es la cantidad de productos, con ella se inicializan los depositos de cada uno.
     **/
    public Expendedor(int numProducto) {
        coca = new Deposito<Producto>();
        sprite = new Deposito<Producto>();
        fanta = new Deposito<Producto>();
        snicker = new Deposito<Producto>();
        super8 = new Deposito<Producto>();
        monVuelto = new Deposito<Moneda>();
        depositoMonedas = new Deposito<Moneda>();
        productosComprados = new Deposito<Producto>();
        for (int i = 0; i < numProducto; i++) {
                coca.addElemento(new CocaCola());
                sprite.addElemento(new Sprite());
                fanta.addElemento(new Fanta());
                snicker.addElemento(new Snicker());
                super8.addElemento(new Super8());
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
        Producto producto = null;
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
            productosComprados.addElemento(producto);
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
        return productosComprados.getElemento();
    }

    /**
     * Este metodo es para uso de paquetes de display, para tener la informacion interna del los depositos
     * @param tipo el tipo de producto del deposito que se quiere
     * @return el deposito del tipo seleccionado
     */
    public Deposito<Producto> getDeposito(SeleccionProducto tipo){
        switch(tipo){
            case COCA_COLA:
                return coca;
            case SPRITE:
                return sprite;
            case FANTA:
                return fanta;
            case SNICKER:
                return snicker;
            case SUPER8:
                return super8;
            default:
                return null;
        }
    }
    public Deposito<Producto> getDepoProducto(){ return productosComprados;}
    public Deposito<Moneda> getDepositoMonedas(){return depositoMonedas;}
    public Deposito<Moneda> getDepoVuelto(){return monVuelto;}
}
