package visual;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import programa.Deposito;
import programa.Producto;
import programa.SeleccionProducto;

public class PanelDeposito extends JPanel {
    private Image imagenProducto;
    private Deposito<Producto> deposito;

    public PanelDeposito(Deposito<Producto> deposito, SeleccionProducto tipo){
        //TODO
        this.deposito = deposito;
        String filename;
        switch (tipo){
            case SNICKER:
                filename = "recursos/snicker.png";
                break;
            case COCA_COLA:
                filename = "recursos/cocacola.png";
                break;
            default:
                filename = "recursos/product.png";

        }
        imagenProducto = new ImageIcon(filename).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        setBorder(border);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        //g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        if(deposito == null)return;
        if(deposito.getAmount()==0)return;
        float step = (float)getWidth() / deposito.getAmount();

        float pos = getWidth()-20;
        for(Producto p : deposito.getArray()){
            g2d.drawImage(imagenProducto,(int)pos,0,this);
            pos-=step;
        }


    }
}
