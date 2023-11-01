package programa;
import visual.PanelPrincipal;
import visual.Ventana;

import javax.swing.*;

/**
 * @author Gabriela Muñoz
 * @author Felicia Pino
 * En programa.Main se prueban los casos posibles a la hora de comprar un producto.
 */
public class Main{
    public static void main(String[] args) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Ventana ventana = new Ventana();
        PanelPrincipal panel = new PanelPrincipal();
        ventana.add(panel);
        ventana.setVisible(true);

        //Caso: normal.
        Expendedor e1 = new Expendedor(1);
        Moneda m1 = new Moneda500();
        Comprador c1 = new Comprador(m1, Enumeracion.COCA_COLA, e1);
        System.out.println("El producto escogido es: " + c1.queBebiste() + "." + "\nSu vuelto es de: $" + c1.cuantoVuelto() + ".\n");
        System.out.println("Numero de serie de la moneda: "+m1.getSerie());

        //Caso: moneda insuficiente.
        try {
            Expendedor e2 = new Expendedor(1);
            Moneda m2 = new Moneda100();
            Comprador c2 = new Comprador(m2, Enumeracion.SPRITE, e2);
            System.out.println("El producto escogido es: " + c2.queBebiste() + "." + "\nSu vuelto es de: $" + c2.cuantoVuelto() + ".\n");
        } catch(Exception PagoInsuficienteException) {
            System.out.println("El pago es insuficiente.\n");
        }

        //Caso: no hay producto.
        try {
            Expendedor e3 = new Expendedor(0);
            Moneda m3 = new Moneda500();
            Comprador c3 = new Comprador(m3, Enumeracion.FANTA, e3);
            System.out.println("El producto escogido es: " + c3.queBebiste() + "." + "\nSu vuelto es de: $" + c3.cuantoVuelto() + ".\n");
        } catch(Exception NoHayProductoException){
            System.out.println("No hay suficientes productos en la maquina expendedora.\n");
        }

        try {
            Expendedor e4 = new Expendedor(1);
            Moneda m4 = null;
            Comprador c4 = new Comprador(m4, Enumeracion.SNICKER, e4);
            System.out.println("El producto escogido es: " + c4.queBebiste() + "." + "\nSu vuelto es de: $" + c4.cuantoVuelto() + ".\n");
        } catch(Exception PagoIncorrectoException) {
            System.out.println("El pago ingresado es incorrecto.\n");
        }
    }
}
