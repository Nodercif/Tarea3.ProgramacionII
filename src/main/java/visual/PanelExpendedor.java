package visual;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private PanelPrincipal panelPrincipal;
    public PanelExpendedor (PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        this.setLocale(null);
        this.setBackground(new Color(255, 255, 204));
    }

    public void paint(Graphics g) {
        super.paint(g);
    }
}
