package schedule.components.label;

import schedule.*;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;

public class WeaponImageLabel extends ImageLabel {
    private final int width = 70;
    private final int height = 70;

    public WeaponImageLabel(String resourcePass) {
        super(null);
        setIcon(loadWeaponImage(resourcePass));
        setPreferredSize(new Dimension(width, height));
    }

    private ImageIcon loadWeaponImage(String resourcePath) {
        try {
            URL url = SplaScheduleUtils.getURL(resourcePath);
            if (url == null) {
                System.out.println("Incorrect URL");
                return null;
            }
            BufferedImage image = ImageIO.read(url);
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            return new ImageIcon(resizedImage);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Could not find resource");
        return null;
    }
}
