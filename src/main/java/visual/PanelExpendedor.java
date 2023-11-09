package visual;

import javax.swing.*;
import javax.swing.border.Border;

import programa.*;

import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelExpendedor extends JPanel {
    private JPanel panelMoneda;
    private JPanel panelDepositos;
    private JPanel  panelBotones;
    private JPanel panelMensajeDeError = new JPanel();
    private JPanel fondoMaquina = new JPanel();
    private PanelDeposito depositoMonedas;
    private MonedaVisual moneda;
    private PanelDeposito depositoVuelto;
    private PanelDeposito receptaculo;//Deberia poner un mejor nombre. el custion de donde se saca lo que compraste
    private JButton cocacolaButton = new JButton();
    private JButton spriteButton = new JButton();
    private JButton fantaButton = new JButton();
    private JButton snickerButton = new JButton();
    private JButton super8Button = new JButton();
    private JLabel EDisplayMessage = new JLabel();

    private Expendedor exp;

    public PanelExpendedor(int numProductos){
        super();
        exp = new Expendedor(numProductos);
        this.setLayout(null);
        //moneda seleccionada
        panelMoneda = new JPanel(new GridLayout());
        panelMoneda.setBounds(15, 190, 50, 60);
        panelMoneda.setBackground(new Color(0, 0, 68));
        this.add(panelMoneda);
        //panel de botones
        panelBotones = new JPanel(new GridLayout(5,1));
        panelBotones.setBounds(getX()+310, 100, 150, 350);
        panelBotones.setVisible(true);
        this.add(panelBotones);
        JPanel bordePanel = new JPanel();
        bordePanel.setBounds(305, 95, 160, 360);
        bordePanel.setBackground(new Color(10, 10, 10));
        bordePanel.setVisible(true);
        add(bordePanel);

        //botones
        buttonSetup(cocacolaButton,SeleccionProducto.COCA_COLA,"Coca-Cola");
        buttonSetup(spriteButton,SeleccionProducto.SPRITE,"Sprite");
        buttonSetup(fantaButton,SeleccionProducto.FANTA,"Fanta");
        buttonSetup(snickerButton,SeleccionProducto.SNICKER,"Snicker");
        buttonSetup(super8Button,SeleccionProducto.SUPER8,"Super8");
        
        //panel de depositos
        panelDepositos = new JPanel(new GridBagLayout());
        panelDepositos.setBounds(90,70,200,300);
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
        receptaculo = new PanelDeposito<Producto>(exp.getDepoProducto());
        //receptaculo.setBackground(Color.GRAY);
        receptaculo.setBounds(getX()+120,500,90,60);
        receptaculo.setVisible(true);
        receptaculo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(receptaculo);

        //deposito vuelto
        depositoVuelto = new PanelDeposito<Moneda>(exp.getDepoVuelto());
        depositoVuelto.setBounds(getX()+250,500,90,60);
        depositoVuelto.setVisible(true);
        depositoVuelto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(depositoVuelto);

        //panel mensaje de error
        EDisplayMessage.setText("¡Compre un producto! =)");
        EDisplayMessage.setHorizontalAlignment(SwingConstants.LEFT);
        EDisplayMessage.setForeground(new Color(4, 68, 0));
        EDisplayMessage.setFont(new Font("Monospaced", Font.BOLD, 12));
        panelMensajeDeError.setBackground(new Color(131, 242, 67));
        panelMensajeDeError.setBounds(45, 400, 250, 30);
        panelMensajeDeError.add(EDisplayMessage);
        add(panelMensajeDeError);

        //Fondo maquina expendedora
        fondoMaquina.setBackground(new Color(18,52,113));
        fondoMaquina.setBounds(5, 40, 470, 560);
        add(fondoMaquina);
        fondoMaquina.setVisible(true);
        JPanel bordeFondoMaquina = new JPanel();
        bordeFondoMaquina.setBounds(0, 35, 480,570);
        bordeFondoMaquina.setBackground(new Color(0, 0, 68));
        add(bordeFondoMaquina);

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
    public ProductoVisual sacarProducto(){
        ProductoVisual productoVisual = new ProductoVisual(exp.getProducto());
        repaint();
        return productoVisual;
    }
    public JPanel getReceptaculo(){return receptaculo;}

    private void comprar(SeleccionProducto prod){
        try{
            Moneda m = null;
            if(this.moneda != null) m = this.moneda.getMoneda();
            exp.comprarProducto(m,prod);
            EDisplayMessage.setText("¡Gracias por su compra! =)");
        }catch(NoHayProductoException e){
            EDisplayMessage.setText("No hay Producto en la máquina");
        }catch(PagoInsuficienteException e){
            EDisplayMessage.setText("El pago ingresado es insuficiente");
        }catch(PagoIncorrectoException e){
            EDisplayMessage.setText("El pago ingresado es incorrecto");
        }finally {
            if(this.moneda != null)
                panelMoneda.remove(this.moneda);
            this.moneda = null;
            repaint(); //Para sacar la moneda una vez que se compra.
        }
    }

}
