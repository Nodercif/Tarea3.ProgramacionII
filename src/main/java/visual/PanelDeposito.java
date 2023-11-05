package visual;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

import programa.Deposito;
import programa.Producto;
import programa.SeleccionProducto;
import programa.Moneda;

public class PanelDeposito<T> extends JPanel {
    private Deposito<T> deposito;
    public PanelDeposito(Deposito<T> deposito){
        super();
        this.deposito = deposito;
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        setBorder(border);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        //g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
        if(deposito == null)return;
        if(deposito.getAmount()<=0)return;

        float step = (float)getWidth() / (deposito.getAmount()+1);
        float pos = getWidth()-step-20;
        for(T t : deposito.getArray()){
            JLabel itemVisual = null;
            if(t instanceof Moneda){
                itemVisual = new MonedaVisual((Moneda)t);
            }if(t instanceof Producto){
                itemVisual = new ProductoVisual((Producto) t);
            }
            if(itemVisual != null) {
                itemVisual.getIcon().paintIcon(this, g2d, (int) pos, 0);
                g.setFont(new Font("Comic Sans",Font.BOLD,7));
                g.drawString(itemVisual.getText(),(int)pos+12, 35);
            }
            pos-=step;
        }


    }
}
