/**
 * La clase Deposito genera un depósito genérico para los diferentes productos de la máquina expendedora y para
 * las monedas.
 **/
import java.util.ArrayList;
public class Deposito<T>{
    private ArrayList<T> var;
    /**
     * El contructor inicializa el ArrayList que guardará cada producto.
     **/
    public Deposito(){
        var = new ArrayList<T>();
    }
    /**
     * El método addElemento añade un elemento a la lista.
     * @param a es el nuevo elemento que se agrega.
     **/
    public void addElemento(T a){
        var.add(a);
    }
    /**
     * El método getElemento extrae un elemento de la lista.
     * @return aux entrega el elemento que fue extraido.
     **/
    public T getElemento(){
        if(var.size() <= 0){
            return null;
        }
        else{
            T aux = var.get(0);
            var.remove(0);
            return aux;
        }
    }
}