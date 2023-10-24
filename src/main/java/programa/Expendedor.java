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
     * @param enumeracion es el tipo de producto que se pidió.
     * @return devuelve el prodcuto que se obtuvo de la máquina, este puede ser de tipo bebida o dulce.
     * @throws NoHayProductoException ocurre cuando a la máquina no le queda el producto que se trata de comprar.
     * @throws PagoInsuficienteException la moneda que se inserta no es suficiente para comprar el producto.
     * @throws PagoIncorrectoException se le paso una moneda nula, no hay moneda.
     **/
    public Producto comprarProducto(Moneda moneda, Enumeracion enumeracion) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        if(moneda == null){
            throw new PagoIncorrectoException("Pago incorrecto.");
        }
        int valorMoneda = moneda.getValor();
        if (valorMoneda < enumeracion.getPrecio()) {
            monVuelto.addElemento(moneda);
            throw new PagoInsuficienteException("Pago insuficiente.");
        }

        Bebida b = null;
        Dulce d = null;
        switch (enumeracion) {
            case COCA_COLA:
                b = coca.getElemento();
                break;
            case SPRITE:
                b = sprite.getElemento();
                break;
            case FANTA:
                b = fanta.getElemento();
                break;
            case SNICKER:
                d = snicker.getElemento();
                break;
            case SUPER8:
                d = super8.getElemento();
        }

        if(b != null) {
            if(valorMoneda == enumeracion.getPrecio()){
                producto = b;
                return b;
            }
            else {
                valorMoneda -= enumeracion.getPrecio();
                while (valorMoneda != 0) {
                    monVuelto.addElemento(new Moneda100());
                    valorMoneda = valorMoneda - 100;
                }
                producto = b;
                return b;
            }
        }
        else if(d != null) {
            if(valorMoneda == enumeracion.getPrecio()){
                producto = d;
                return d;
            }
            else {
                valorMoneda -= enumeracion.getPrecio();
                while (valorMoneda != 0) {
                    monVuelto.addElemento(new Moneda100());
                    valorMoneda = valorMoneda - 100;
                }
                producto = d;
                return d;
            }
        }
        else{
            monVuelto.addElemento(moneda);
            throw new NoHayProductoException("No hay producto.");
        }
    }

    /**
     * Método getVuelto:
     * @return entrega el vuelto en monedas de $100.
     */
    public Moneda getVuelto(){
        return monVuelto.getElemento();
    }
}
