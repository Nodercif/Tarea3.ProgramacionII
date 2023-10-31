package visual;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador comprador;
    private PanelExpendedor expendedor;

    public  PanelPrincipal(){
        super();
        comprador = new PanelComprador();
        expendedor = new PanelExpendedor();
        this.setBackground(new Color(255, 255, 204));
    }

    public void paint (Graphics g) {
        super.paint(g);
        comprador.paint(g);
        expendedor.paint(g);
    }
}
