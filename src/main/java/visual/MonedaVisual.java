package visual;

import javax.swing.*;
import javax.swing.border.Border;

import programa.Moneda;
import programa.Moneda100;
import programa.Moneda500;
import programa.Moneda1000;
import programa.Moneda1500;

import java.awt.*;

public class MonedaVisual extends JLabel {
    private Moneda moneda;
    public MonedaVisual(Moneda m){
        super();
        this.moneda = m;
        String imgPath = "recursos/coin.png";
        if(m instanceof Moneda100)imgPath = "recursos/moneda100.png";
        if(m instanceof Moneda500)imgPath = "recursos/moneda500.png";
        if(m instanceof Moneda1000)imgPath = "recursos/moneda1000.png";
        if(m instanceof Moneda1500)imgPath = "recursos/moneda1500.png";

        //Borrar
        //de hecho no, la tarea dice que deben mostrar el numero de serie
        //igual podria ser que se muestre en la terminal al interactuar con la moneda, pero no me tinca tanto
        //creo que seria mejor hacer el texto mas sutil

        setText(""+m.getSerie());
        setHorizontalAlignment(JLabel.RIGHT);
        setVerticalAlignment(JLabel.TOP);
        setForeground(Color.GRAY);
        setFont(new Font("Arial",Font.BOLD,12));
        setIconTextGap(-12);

        //hacemos un icono nuevo
        ImageIcon iconoMoneda = new ImageIcon(imgPath);
        //escalamos la imagen del icono
        iconoMoneda.setImage(iconoMoneda.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
        //seteamos el icone de este label al icono que acabamos de crear
        setIcon(iconoMoneda);

    }
    public Moneda getMoneda(){return this.moneda;}
}
