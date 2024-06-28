package components.button;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class LobbyButton extends JButton {
    private final int width = 50;
    private final int height = 50;

    public LobbyButton(String resourcePass) {
        super((Icon) null);
        setIcon(loadButtonImage(resourcePass));
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.ORANGE);
    }

    public ImageIcon loadButtonImage(String resourcePath) {
        try {
            File file = new File(resourcePath);
            BufferedImage image = ImageIO.read(file);
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            return new ImageIcon(resizedImage);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Could not find resource");
        return null;
    }
}
