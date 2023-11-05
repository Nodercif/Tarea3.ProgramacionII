package visual;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import programa.Deposito;
import programa.Producto;
import programa.SeleccionProducto;

public class PanelDeposito<T> extends JPanel {
    private Image imagenProducto;
    private Deposito<T> deposito;
    public PanelDeposito(Deposito<T> deposito, String filename){
        super();
        this.deposito = deposito;
        imagenProducto = new ImageIcon(filename).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        setBorder(border);
    }

    public PanelDeposito(Deposito<T> deposito, SeleccionProducto tipo){
        super();
        this.deposito = deposito;
        String filename;
        switch (tipo){
            case SNICKER:
                filename = "recursos/snicker.png";
                break;
            case COCA_COLA:
                filename = "recursos/cocacola.png";
                break;
            case FANTA:
                filename = "recursos/fanta.png";
                break;
            case SPRITE:
                filename = "recursos/sprite.png";
                break;
            case SUPER8:
                filename = "recursos/super8.png";
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
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
        if(deposito == null)return;
        if(deposito.getAmount()==0)return;
        float step = (float)getWidth() / deposito.getAmount();

        float pos = getWidth()-20;
        for(T p : deposito.getArray()){
            g2d.drawImage(imagenProducto,(int)pos,0,this);
            pos-=step;
        }


    }
}
