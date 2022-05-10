package farahalkarrad;

import java.awt.Graphics;
import javax.swing.*;

public class Image extends JPanel {

    private ImageIcon i;

    public Image() {
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        i = new ImageIcon(getClass().getResource("..\\img\\background.jpg"));
        i.paintIcon(this, g, 0, 0);
    }

}
