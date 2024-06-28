package schedule.components.panel;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractSchedulePanel extends JPanel {

    public AbstractSchedulePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        createPanel();
        setOpaque(false);
    }

    public abstract void createPanel();

    public void setBackgroundColor(Color color) {
        setBackground(color);
        // パネル内のコンポーネントにも同じ背景色を適用
        Component[] components = getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                component.setBackground(color);
            }
        }
    }
}
