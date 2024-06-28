package schedule.schedules;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SplaScheduleGui().setVisible(true));
    }
}
