package schedule.schedules;

/**
 * ゲームモードを表す列挙型です。
 */
public enum GameMode {
    CHALLENGE("チャレンジ"),
    OPEN("オープン");

    private final String displayName;  // ゲームモードの表示名

    /**
     * コンストラクタ。
     *
     * @param displayName ゲームモードの表示名
     */
    GameMode(String displayName) {
        this.displayName = displayName;
    }

    /**
     * ゲームモードの表示名を取得します。
     * @return ゲームモードの表示名
     */
    public String getDisplayName() {
        return displayName;
    }
}