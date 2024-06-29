package schedule.components.panel;

import javax.swing.*;
import java.awt.*;

public abstract class ShapePanel extends JPanel {
    public ShapePanel() {
        super();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawShape(g);
    }

    protected abstract void drawShape(Graphics g);
}