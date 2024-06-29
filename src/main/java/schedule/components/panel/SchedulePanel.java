package schedule.components.panel;

import javax.swing.*;
import java.awt.*;

public class SchedulePanel extends JPanel {
    private final RoundedPanel roundedPanel;

    public SchedulePanel() {
        super();
        roundedPanel = new RoundedPanel(20);
        roundedPanel.setLayout(new BoxLayout(roundedPanel, BoxLayout.Y_AXIS));
        roundedPanel.setBackground(Color.LIGHT_GRAY);

        super.add(roundedPanel);
    }

    @Override
    public Component add(Component component) {
        roundedPanel.add(component);
        return component;
    }
}
