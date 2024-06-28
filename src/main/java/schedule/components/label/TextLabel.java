package schedule.components.label;

import javax.swing.*;
import java.awt.*;

public class TextLabel extends JLabel {
    public TextLabel(String text) {
        super(text);
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}