package components.label;

import schedule.*;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;

public class StageImageLabel extends ImageLabel {
    protected int width = 200;
    protected int height = 100;

    protected String resourcePath;

    public StageImageLabel(String resourcePath) {
        super(null);
        this.resourcePath = resourcePath;
        setIcon(loadStageImage(resourcePath, width, height));
        setPreferredSize(new Dimension(width, height));
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setStageSize(int width, int height) {
        setIcon(loadStageImage(getResourcePath(), width, height));
        setPreferredSize(new Dimension(width, height));
    }

    protected ImageIcon loadStageImage(String resourcePath, int width, int height) {
        try {
            URL url = SplaSchedule.getURL(resourcePath);
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
