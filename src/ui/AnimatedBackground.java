package ui;
import javax.swing.*;
import java.awt.*;

public class AnimatedBackground extends JPanel {

    private Image bgImage;

    public AnimatedBackground(String imagePath) {
        bgImage = new ImageIcon(imagePath).getImage();
        setLayout(new GridBagLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Scale image to window size
        g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
    }
}

