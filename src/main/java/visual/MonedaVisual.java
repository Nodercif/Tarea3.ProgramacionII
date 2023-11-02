package visual;

import javax.swing.*;
import javax.swing.border.Border;

import programa.Moneda;

import java.awt.*;

public class MonedaVisual extends JLabel {
    private Moneda moneda;
    public MonedaVisual(Moneda m){
        super();
        this.moneda = m;
        ImageIcon iconoMoneda = new ImageIcon("recursos/coin.png");
        setIcon(iconoMoneda);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        this.setBorder(border);
    }
    public Moneda getMoneda(){return this.moneda;}
}
