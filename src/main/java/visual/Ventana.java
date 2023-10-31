package visual;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame {

    public Ventana() {
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("Maquina Expendedora");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}