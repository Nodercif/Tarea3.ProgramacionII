package visual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import programa.Moneda100;
import programa.Moneda500;
import programa.Moneda1000;
import programa.Moneda1500;
import programa.Expendedor;

public class PanelComprador extends JPanel {
    private JPanel panelMonedero;
    private JPanel panelMochila;
    private PanelExpendedor expendedor;

    public PanelComprador(){
        super();
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(30,30,10,120);

        panelMonedero = new JPanel();
        panelMonedero.setBackground(new Color(100,60,40));
        this.add(panelMonedero, constraints);
        constraints.gridy = 1;
        panelMochila = new JPanel();
        this.add(panelMochila,constraints);
        panelMochila.setBackground(new Color(180,60,70));

        for(int i = 0; i<3; i++){
            MonedaVisual m = new MonedaVisual(new Moneda500());
            m.setVisible(true);
            panelMonedero.add(m);
        }
        for(int i = 0; i<4; i++){
            MonedaVisual m = new MonedaVisual(new Moneda100());
            m.setVisible(true);
            panelMonedero.add(m);
        }
        for(int i = 0; i<3; i++){
            MonedaVisual m = new MonedaVisual(new Moneda1500());
            m.setVisible(true);
            panelMonedero.add(m);
        }
        for(int i = 0; i<3; i++){
            MonedaVisual m = new MonedaVisual(new Moneda1000());
            m.setVisible(true);
            panelMonedero.add(m);
        }
        panelMonedero.setVisible(true);

    }

    public void setExpendedor(PanelExpendedor expendedor) {
        this.expendedor = expendedor;
    }

    public void procesarClick(int x, int y){
        //revisar si hicimos click en las monedas
        for(Component c : panelMonedero.getComponents()){
            if(! (c instanceof MonedaVisual))continue;
            MonedaVisual secMon = (MonedaVisual) c;
            int mx = secMon.getX()+panelMonedero.getX();
            int my = secMon.getY()+panelMonedero.getY();
            boolean clickEnLaMoneda = (x>=mx && x<mx+secMon.getWidth() && y>=my && y<my+ secMon.getHeight());
            if(clickEnLaMoneda){
                //seleccionar la moneda para usar en el expendedor

                MonedaVisual monedaDeseleccionada = expendedor.seleccionarMoneda(secMon);
                panelMonedero.remove(secMon);
                if(monedaDeseleccionada != null){
                    panelMonedero.add(monedaDeseleccionada);
                }
                panelMonedero.revalidate();
                super.repaint();
            }
        }
        //revisar si tratamos de sacar el articulo comprado
        JPanel r = expendedor.getReceptaculo();//El panel del compartimiente del que se saca el producto
        if(r==null)return;
        int rx = r.getX()+expendedor.getX();
        int ry = r.getY()+expendedor.getY();
        int rw = r.getWidth();
        int rh = r.getHeight();
        boolean clickEnElreceptaculo = x>=rx && x<rx+rw && y>=ry && y<ry+rh;
        if(clickEnElreceptaculo){
            ProductoVisual prod = expendedor.sacarProducto();
            if(prod != null){
                panelMochila.add(prod);
            }
        }
        //revisar si tratamos de sacar vuelto
        JPanel v = expendedor.getPanelVuelto();
        if(v==null)return;
        int vx = v.getX()+expendedor.getX();
        int vy = v.getY()+expendedor.getY();
        int vw = v.getWidth();
        int vh = v.getHeight();
        boolean clickEnDepoMonedas = x>=vx && x<vx+vw && y>=vy && y<vy+vh;
        if(clickEnDepoMonedas){
            MonedaVisual m = expendedor.sacarMoneda();
            if(m!=null) {
                panelMonedero.add(m);
                panelMonedero.revalidate();
                super.repaint();
            }
        }
    }

}
