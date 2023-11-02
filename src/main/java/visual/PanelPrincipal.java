package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPrincipal extends JPanel {
    private PanelComprador comprador;
    private PanelExpendedor expendedor;

    public  PanelPrincipal(){
        super();
        comprador = new PanelComprador();
        expendedor = new PanelExpendedor(6);
        comprador.setExpendedor(expendedor);
        this.setBackground(new Color(255, 255, 204));
        this.setLayout(new GridLayout(1,2));
        this.add(comprador);
        this.add(expendedor);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                comprador.procesarClick(e.getX(),e.getY());
            }
        });
    }

    public void paint (Graphics g) {
        super.paint(g);
    }
}
