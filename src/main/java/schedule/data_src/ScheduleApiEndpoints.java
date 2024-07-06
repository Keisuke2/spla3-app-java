package schedule.data_src;

/**
 * Splatoon 3 のスケジュールAPIエンドポイントを定義するクラスです。
 * 各ゲームモードやイベントに対応するAPIのURLを定数として提供します。
 */
public final class ScheduleApiEndpoints {
    /**
     * 全スケジュール（非推奨）
     */
    public final static String all = "https://spla3.yuu26.com/api/schedule";

    /**
     * レギュラーマッチのスケジュール
     */
    public final static String regular = "https://spla3.yuu26.com/api/regular/schedule";

    /**
     * バンカラマッチ（オープン）のスケジュール
     */
    public final static String bankaraOpen = "https://spla3.yuu26.com/api/bankara-open/schedule";

    /**
     * バンカラマッチ（チャレンジ）のスケジュール
     */
    public final static String bankaraChallenge = "https://spla3.yuu26.com/api/bankara-challenge/schedule";

    /**
     * Xマッチのスケジュール
     */
    public final static String x = "https://spla3.yuu26.com/api/x/schedule";

    /**
     * イベントマッチのスケジュール
     */
    public final static String event = "https://spla3.yuu26.com/api/event/schedule";

    /**
     * フェスマッチ（オープン）のスケジュール
     */
    public final static String festOpen = "https://spla3.yuu26.com/api/fest/schedule";

    /**
     * フェスマッチ（チャレンジ）のスケジュール
     */
    public final static String festChallenge = "https://spla3.yuu26.com/api/fest-challenge/schedule";

    /**
     * サーモンランのスケジュール
     */
    public final static String salmonRun = "https://spla3.yuu26.com/api/coop-grouping/schedule";

    /**
     * サーモンランコンテストのスケジュール
     */
    public final static String salmonrunContest = "https://spla3.yuu26.com/api/coop-grouping-team-contest/schedule";
}