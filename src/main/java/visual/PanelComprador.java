package visual;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    private PanelPrincipal panelPrincipal;
    public PanelComprador (PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        this.setLocale(null);
        this.setBackground(new Color(255, 255, 204));
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

}
