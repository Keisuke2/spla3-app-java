package schedule.components.panel;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractLobbyPanel extends JPanel {
    protected JLabel lobbyLabel = new JLabel();

    public AbstractLobbyPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        lobbyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        createPanel();
        setOpaque(false);
    }

    public abstract void createPanel();
}
