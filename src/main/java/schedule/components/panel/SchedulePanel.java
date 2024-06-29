package schedule.components.panel;

import javax.swing.*;
import java.awt.*;

public class SchedulePanel extends JPanel {
    private final ShapePanel shapePanel;

    public SchedulePanel() {
        super();
        shapePanel = new RectanglePanel();
        shapePanel.setLayout(new BoxLayout(shapePanel, BoxLayout.Y_AXIS));
        shapePanel.setBackground(Color.LIGHT_GRAY);

        super.add(shapePanel);
    }

    @Override
    public Component add(Component component) {
        shapePanel.add(component);
        return component;
    }
}
