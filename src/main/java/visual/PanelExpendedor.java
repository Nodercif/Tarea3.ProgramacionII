package visual;

import javax.swing.*;
import programa.Expendedor;
import programa.Moneda;
import programa.SeleccionProducto;

import java.awt.*;

public class PanelExpendedor extends JPanel {
    private JPanel panelMoneda;
    private MonedaVisual moneda;
    private JPanel panelDepositos;
    private JPanel  panelBotones;
    private PanelDeposito depositoMonedas;
    private PanelDeposito depositoVuelto;
    private JPanel receptaculo;//Deberia poner un mejor nombre. el custion de donde se saca lo que compraste
    private JButton cocacola = new JButton();
    private JButton sprite = new JButton();
    private JButton fanta = new JButton();
    private JButton snicker = new JButton();
    private JButton super8 = new JButton();

    private Expendedor exp;

    public PanelExpendedor(int numProductos){
        super();
        exp = new Expendedor(numProductos);
        this.setLayout(null);
        panelMoneda = new JPanel();
        //TODO posicion del panel de la moneda
        panelMoneda.setBounds(100, 100, 500, 1000);
        this.add(panelMoneda);

        panelBotones = new JPanel(new GridLayout(6,1));
        //TODO poner botones al panel de botones y definir la posicion
        //cocacola.setBounds();
        panelBotones.setBackground(Color.GRAY);
        panelBotones.setVisible(true);

        this.add(panelBotones);
        panelDepositos = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //TODO set the constraints
        for(SeleccionProducto tipo : SeleccionProducto.values()){
            //TODO hay que ponerlse los constraints a cada uno
            PanelDeposito dep = new PanelDeposito(exp.getDeposito(tipo), tipo);
            panelDepositos.add(dep,constraints);
        }

    }

    /**
     * Se le pasa una moneda para tener como seleccion para usar en la compra.
     * La idea es intercambiar la moneda nueva con la que ya estaba seleccionada, si ya habia una seleccionada,claro.
     * @param mon la moneda que se quiere seleccionar
     * @return la moneda que ya estaba seleccionada
     */
    public MonedaVisual seleccionarMoneda(MonedaVisual mon){
        MonedaVisual ret = this.moneda;
        if(this.moneda != null)panelMoneda.remove(this.moneda);
        this.moneda = mon;
        panelMoneda.add(moneda);
        return ret;
    }
}
