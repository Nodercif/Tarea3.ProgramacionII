package visual;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador comprador;
    private PanelExpendedor expendedor;

    public  PanelPrincipal(){
        super();
        comprador = new PanelComprador();
        expendedor = new PanelExpendedor(6);
        this.setBackground(new Color(255, 255, 204));
        this.setLayout(new GridLayout(1,2));
        this.add(comprador);
        this.add(expendedor);
    }

    public void paint (Graphics g) {
        super.paint(g);
    }
}
