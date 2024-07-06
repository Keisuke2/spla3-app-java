package schedule;

import schedule.schedules.*;

/**
 * コマンドラインインターフェース（CLI）を使用して
 * Splatoon 3 のスケジュールを表示するクラスです。
 */
public class SplaScheduleCli {
    public static void main(String[] args) {
        new SplaScheduleCli().showSchedule();
    }

    /**
     * スケジュールを表示します。
     */
    public void showSchedule() {
        Regular regular = new Regular();
        regular.showSchedule();
    }
}