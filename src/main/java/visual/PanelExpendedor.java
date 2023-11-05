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
        //moneda seleccionada
        panelMoneda = new JPanel(new GridLayout());
        panelMoneda.setBounds(getX(), 300, 60, 60);
        this.add(panelMoneda);
        //panel de botones
        panelBotones = new JPanel(new GridLayout(5,1));
        panelBotones.setBounds(getX()+320, 100, 150, 350);
        panelBotones.setBackground(Color.GRAY);
        panelBotones.setVisible(true);

        this.add(panelBotones);
        //botones
        buttonSetup(cocacolaButton,SeleccionProducto.COCA_COLA,"Coca-Cola");
        buttonSetup(spriteButton,SeleccionProducto.SPRITE,"Sprite");
        buttonSetup(fantaButton,SeleccionProducto.FANTA,"Fanta");
        buttonSetup(snickerButton,SeleccionProducto.SNICKER,"Snicker");
        buttonSetup(super8Button,SeleccionProducto.SUPER8,"Super8");

        //panel de depositos
        panelDepositos = new JPanel(new GridBagLayout());
        panelDepositos.setBounds(100,70,200,300);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        panelDepositos.setBorder(border);
        this.add(panelDepositos);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy=0; constraints.gridx=0;
        constraints.weightx=1; constraints.weighty=1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(5,0,5,0);
        for(SeleccionProducto tipo : SeleccionProducto.values()){
            PanelDeposito<Producto> dep = new PanelDeposito<Producto>(exp.getDeposito(tipo));
            dep.setBackground(new Color(70,160,220));
            panelDepositos.add(dep,constraints);
            constraints.gridy += 1;
        }
        //receptaculo de extaccion
        receptaculo = new JPanel();
        receptaculo.setBackground(Color.GRAY);
        receptaculo.setBounds(getX()+120,550,90,60);
        receptaculo.setVisible(true);
        add(receptaculo);
        //deposito vuelto
        depositoVuelto = new PanelDeposito<Moneda>(exp.getDepoVuelto());
        depositoVuelto.setBounds(getX()+250,550,90,60);
        depositoVuelto.setVisible(true);
        add(depositoVuelto);

    }
    private void buttonSetup(JButton button, SeleccionProducto tipo, String nombre){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprar(tipo);
            }
        });
        button.setText(nombre);
        button.setFont(new Font("Comic Sans",Font.BOLD,12));
        button.setMargin(new Insets(5,-3,5,0));
        button.setFocusable(false);
        panelBotones.add(button);
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
        this.moneda = secMon;
        panelMoneda.add(moneda);
        panelMoneda.revalidate();
        super.repaint();
        return ret;
    }
    public MonedaVisual sacarMoneda(){
        MonedaVisual ret = null;
        Moneda m = exp.getVuelto();
        if(m!=null)
            ret = new MonedaVisual(m);
        repaint();
        return ret;
    }
    public JPanel getPanelVuelto(){return (JPanel) depositoVuelto;}

    private void comprar(SeleccionProducto prod){
        try{
            Moneda m = null;
            if(this.moneda != null) m = this.moneda.getMoneda();
            exp.comprarProducto(m,prod);
        }catch(NoHayProductoException e){
            EDisplayMessage = e.getMessage();
        }catch(PagoInsuficienteException e){
            EDisplayMessage = e.getMessage();
        }catch(PagoIncorrectoException e){
            EDisplayMessage = e.getMessage();
        }finally {
            if(this.moneda != null)
                panelMoneda.remove(this.moneda);
            this.moneda = null;
            repaint();
        }
    }

    public JPanel getReceptaculo(){return receptaculo;}
}
