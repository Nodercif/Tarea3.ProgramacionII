package visual;

import javax.swing.*;
import javax.swing.border.Border;

import programa.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelExpendedor extends JPanel {
    private JPanel panelMoneda;
    private MonedaVisual moneda;
    private JPanel panelDepositos;
    private JPanel  panelBotones;
    private PanelDeposito depositoMonedas;
    private PanelDeposito depositoVuelto;
    private JPanel receptaculo;//Deberia poner un mejor nombre. el custion de donde se saca lo que compraste
    private JButton cocacolaButton = new JButton();
    private JButton spriteButton = new JButton();
    private JButton fantaButton = new JButton();
    private JButton snickerButton = new JButton();
    private JButton super8Button = new JButton();
    private String EDisplayMessage;

    private Expendedor exp;

    public PanelExpendedor(int numProductos){
        super();
        EDisplayMessage = "compre producto! :)";
        exp = new Expendedor(numProductos);
        this.setLayout(null);
        panelMoneda = new JPanel(new GridLayout());
        panelMoneda.setBounds(getX(), 300, 60, 60);
        this.add(panelMoneda);

        panelBotones = new JPanel(new GridLayout(6,1));
        //TODO poner botones al panel de botones y definir la posicion
        panelBotones.setBounds(getX()+300, 100, 60, 300);
        panelBotones.setBackground(Color.GRAY);
        panelBotones.setVisible(true);

        this.add(panelBotones);

        cocacolaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprar(SeleccionProducto.COCA_COLA);
            }
        });
        cocacolaButton.setText("Coca-Cola");
        cocacolaButton.setFocusable(false);
        panelBotones.add(cocacolaButton);
        spriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprar(SeleccionProducto.SPRITE);
            }
        });
        spriteButton.setText("Coca-Cola");
        spriteButton.setFocusable(false);
        panelBotones.add(spriteButton);

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
        super.repaint();
        return ret;
    }

    private void comprar(SeleccionProducto prod){
        try{
            Moneda m = null;
            if(moneda != null) m = moneda.getMoneda();
            exp.comprarProducto(m,prod);
            panelMoneda.remove(moneda);
            moneda = null;
        }catch(NoHayProductoException e){
            EDisplayMessage = e.getMessage();
        }catch(PagoInsuficienteException e){
            EDisplayMessage = e.getMessage();
        }catch(PagoIncorrectoException e){
            EDisplayMessage = e.getMessage();
        }finally {
            repaint();
        }
    }

    public JPanel getReceptaculo(){return receptaculo;}

}
