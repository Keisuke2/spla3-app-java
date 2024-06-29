package schedule.components.panel;

import java.awt.*;

public class RectanglePanel extends ShapePanel {
    public RectanglePanel() {
        super();
    }

    @Override
    protected void drawShape(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draws the rectangular panel with borders.
        graphics.setColor(getBackground());
        graphics.fillRect(0, 0, width - 1, height - 1);
        graphics.setColor(getForeground());
        graphics.drawRect(0, 0, width - 1, height - 1);
    }
}