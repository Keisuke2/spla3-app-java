package schedule;

public enum GameMode {
    CHALLENGE("チャレンジ"),
    OPEN("オープン");

    private final String displayName;

    GameMode(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
