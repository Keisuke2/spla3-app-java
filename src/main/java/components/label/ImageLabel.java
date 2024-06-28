package components.label;

import javax.swing.*;
import java.awt.*;

public class ImageLabel extends JLabel {
    public ImageLabel(ImageIcon image) {
        super(image);
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
