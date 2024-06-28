package schedule.components.panel;

import javax.swing.*;

public class StagePanel extends JPanel {
    public StagePanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
    }
}
