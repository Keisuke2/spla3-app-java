package schedule;

import javax.swing.*;

/**
 * Splatoon 3 スケジュールアプリケーションの起動クラスです。
 * Splatoon 3 のスケジュールをGUIまたはCLIで表示します。
 * 以下のクラスからでもそれぞれ起動できます。
 *
 * @see SplaScheduleGui
 * @see SplaScheduleCli
 */
public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SplaScheduleGui().setVisible(true));
//        new SplaScheduleCli().showSchedule();
    }
}