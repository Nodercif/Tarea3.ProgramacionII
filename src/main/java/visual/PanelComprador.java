package visual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import programa.Moneda500;

public class PanelComprador extends JPanel {
    private JPanel panelMonedero;
    private JPanel panelMochila;
    private PanelExpendedor expendedor;
    private ArrayList<MonedaVisual> monedas;

    public PanelComprador(){
        super();
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(10,10,10,50);

        panelMonedero = new JPanel(new GridLayout());
        this.add(panelMonedero, constraints);
        constraints.gridy = 1;
        panelMochila = new JPanel(new GridLayout());
        this.add(panelMochila,constraints);
        for(int i = 0; i<5; i++){
            MonedaVisual m = new MonedaVisual(new Moneda500());
            m.setVisible(true);
            panelMonedero.add(m);
        }
        this.setVisible(true);
        this.setBackground(new Color(250,0,0,100));
        panelMonedero.setVisible(true);

    }
    public void procesarClick(int x, int y){
        //TODO ver si se hace click in las monedas o en el receptaculo de extraccion del expendedor
        for(Component c : panelMonedero.getComponents()){
            if(! (c instanceof MonedaVisual))continue;
            MonedaVisual secMon = (MonedaVisual) c; //la men
            int mx = secMon.getX();
            int my = secMon.getY();
            boolean clickEnLaMoneda =x>=mx && x<mx+secMon.getWidth() && y>=my && y<my+secMon.getHeight();
            if(clickEnLaMoneda){
                //TODO seleccionar la moneda para usar en el expendedor
                MonedaVisual monedaDeseleccionada = expendedor.seleccionarMoneda(secMon);
                panelMonedero.remove(secMon);
                monedas.remove(secMon);
                if(monedaDeseleccionada != null){
                    monedas.add(monedaDeseleccionada);
                    panelMonedero.add(monedaDeseleccionada);
                }
            }
        }
        boolean clickEnElreceptaculo = false; //TODO
        if(clickEnElreceptaculo){
            //TODO
        }
    }

}
