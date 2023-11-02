package visual;

import javax.swing.*;
import programa.Moneda;

public class MonedaVisual extends JLabel {
    private Moneda moneda;
    public MonedaVisual(){
        super();
        ImageIcon iconoMoneda = new ImageIcon("recursos/moneda.png");
        setIcon(iconoMoneda);
    }
    public Moneda getMoneda(){return this.moneda;}
}
