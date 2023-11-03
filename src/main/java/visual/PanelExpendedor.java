package visual;

import javax.swing.*;
import javax.swing.border.Border;

import programa.Expendedor;
import programa.Moneda;
import programa.Moneda500;
import programa.SeleccionProducto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelExpendedor extends JPanel implements ActionListener {
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
        panelMoneda = new JPanel(new GridLayout());
        panelMoneda.setBounds(getX(), 300, 60, 60);
        this.add(panelMoneda);

        panelBotones = new JPanel(new GridLayout(6,1));
        //TODO poner botones al panel de botones y definir la posicion
        panelBotones.setBounds(getX()+300, 100, 40, 300);
        panelBotones.setBackground(Color.GRAY);
        panelBotones.setVisible(true);


        cocacola.setBounds(0, 100, 70, 30);
        cocacola.addActionListener(this);
        cocacola.setText("Coca-Cola");
        cocacola.setFocusable(false);
        cocacola.setVisible(true);

        this.add(panelBotones);
        //panel de depositos
        panelDepositos = new JPanel(new GridBagLayout());
        panelDepositos.setBounds(100,100,200,300);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        panelDepositos.setBorder(border);
        this.add(panelDepositos);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy=0; constraints.gridx=0;
        constraints.weightx=1; constraints.weighty=1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(5,0,5,0);
        for(SeleccionProducto tipo : SeleccionProducto.values()){
            //TODO hay que ponerlse los constraints a cada uno
            PanelDeposito dep = new PanelDeposito(exp.getDeposito(tipo), tipo);
            panelDepositos.add(dep,constraints);
            constraints.gridy += 1;
        }

    }

    /**
     * Se le pasa una moneda para tener como seleccion para usar en la compra.
     * La idea es intercambiar la moneda nueva con la que ya estaba seleccionada, si ya habia una seleccionada,claro.
     * @param secMon la moneda que se quiere seleccionar
     * @return la moneda que ya estaba seleccionada
     */
    public MonedaVisual seleccionarMoneda(MonedaVisual secMon){
        MonedaVisual ret = this.moneda;
        if(this.moneda != null)panelMoneda.remove(this.moneda);
        else System.out.println("moneda en panel es null");
        this.moneda = secMon;
        panelMoneda.add(moneda);
        panelMoneda.revalidate();
        return ret;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public JPanel getReceptaculo(){return receptaculo;}

}
