package visual;

import javax.swing.*;
import programa.Moneda;

public class MonedaVisual extends JLabel {
    private Moneda moneda;
    public MonedaVisual(Moneda m){
        super();
        this.moneda = m;
        ImageIcon iconoMoneda = new ImageIcon("recursos/coin.png");
        setIcon(iconoMoneda);
    }
    public Moneda getMoneda(){return this.moneda;}
}
