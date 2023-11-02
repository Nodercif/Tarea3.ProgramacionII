package visual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import programa.Moneda500;

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
        constraints.insets = new Insets(30,30,10,80);

        panelMonedero = new JPanel();
        panelMonedero.setBackground(new Color(100,60,40));
        this.add(panelMonedero, constraints);
        constraints.gridy = 1;
        panelMochila = new JPanel();
        this.add(panelMochila,constraints);
        for(int i = 0; i<9; i++){
            MonedaVisual m = new MonedaVisual(new Moneda500());
            m.setVisible(true);
            panelMonedero.add(m);
        }
        panelMonedero.setVisible(true);

    }

    public void setExpendedor(PanelExpendedor expendedor) {
        this.expendedor = expendedor;
    }

    public void procesarClick(int x, int y){
        //TODO ver si se hace click in las monedas o en el receptaculo de extraccion del expendedor
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
                super.repaint();
            }
        }
        JPanel r = expendedor.getReceptaculo();//El panel del compartimiente del que se saca el producto
        if(r==null)return;
        int rx = r.getX()+expendedor.getX();
        int ry = r.getY()+expendedor.getY();
        int rw = r.getWidth();
        int rh = r.getHeight();
        boolean clickEnElreceptaculo = x>=rx && x<rx+rw && y>=ry && y<ry+rh;
        if(clickEnElreceptaculo){
            //TODO
            System.out.println("tratamos de sacar algo");
        }
    }

}
