package schedule;

import schedule.schedules.*;

public class SplaScheduleCli {
    public static void main(String[] args) {
        new SplaScheduleCli().showSchedule();
    }

    public void showSchedule() {
        Regular regular = new Regular();
        regular.showSchedule();
    }
}
