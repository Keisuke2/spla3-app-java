package schedule;

import data_src.*;


public class Fest extends SplaSchedule {
    private final GameMode mode;

    public Fest(boolean isOpen) {
        this.mode = isOpen ? GameMode.OPEN : GameMode.CHALLENGE;
        scheduleURL = isOpen ? ScheduleApi.festOpen : ScheduleApi.festChallenge;
    }

    public String getMode() {
        return mode.getDisplayName();
    }

    @Override
    public void showSchedule() {
        // 実装は変更なし
    }
}
