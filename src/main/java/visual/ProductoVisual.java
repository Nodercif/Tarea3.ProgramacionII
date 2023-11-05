package visual;

import programa.*;

import javax.swing.*;
import java.awt.*;

public class ProductoVisual extends JLabel {
    private Producto producto;
    public ProductoVisual(Producto p){
        super();
        this.producto = p;
        String imgPath = "recursos/product.png";//imagen default
        if(p instanceof CocaCola) imgPath = "recursos/cocacola.png";
        if(p instanceof Sprite) imgPath = "recursos/sprite.png";
        if(p instanceof Fanta) imgPath = "recursos/fanta.png";
        if(p instanceof Snicker) imgPath = "recursos/snicker.png";
        if(p instanceof Super8) imgPath = "recursos/super8.png";


        setText(""+p.getSerie());
        setHorizontalAlignment(JLabel.LEFT);
        setVerticalAlignment(JLabel.BOTTOM);
        setForeground(Color.GRAY);
        setFont(new Font("Arial",Font.BOLD,9));
        setIconTextGap(3);

        //hacemos un icono nuevo
        ImageIcon iconoProducto = new ImageIcon(imgPath);
        //escalamos la imagen del icono
        iconoProducto.setImage(iconoProducto.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
        //seteamos el icone de este label al icono que acabamos de crear
        this.setIcon(iconoProducto);
    }
    public Producto getProducto(){return this.producto;}
}
