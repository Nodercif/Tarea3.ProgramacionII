package visual;
import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    public PanelPrincipal()  {

        super(new BorderLayout());
        this.setLocale(null);
        this.setBackground(new Color(255, 255, 204));
    }
    public void paint(Graphics g) {
        super.paint(g);
    }
}
