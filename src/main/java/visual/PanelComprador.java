package visual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelComprador extends JPanel {
    private JPanel panelMonedero;
    private JPanel panelMochila;
    private PanelExpendedor expendedor;
    private ArrayList<MonedaVisual> monedas;

    public PanelComprador(){
        super();
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //TODO set constraints
        this.add(panelMonedero, constraints);
        this.add(panelMochila,constraints);

    }
    public void procesarClick(int x, int y){
        //TODO ver si se hace click in las monedas o en el receptaculo de extraccion del expendedor
        for(Component c : panelMonedero.getComponents()){
            if(! (c instanceof MonedaVisual))continue;
            MonedaVisual mon = (MonedaVisual) c;
            boolean clickEnLaMoneda = false; //TODO
            if(clickEnLaMoneda){
                //TODO seleccionar la moneda para usar en el expendedor
                //expendedor.seleccionarMoneda()
            }
        }
        boolean clickEnElreceptaculo = false; //TODO
        if(clickEnElreceptaculo){
            //TODO
        }
    }

}
