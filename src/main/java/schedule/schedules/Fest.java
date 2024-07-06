package schedule.schedules;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import schedule.*;
import schedule.data_src.*;

/**
 * フェスマッチのスケジュールを管理するクラスです。
 */
public class Fest {
    private final GameMode mode;  // ゲームモード（オープンまたはチャレンジ）
    private final String scheduleURL;  // スケジュール取得用URL

    /**
     * フェスマッチのインスタンスを作成します。
     *
     * @param isOpen オープンかどうかを指定します。
     */
    public Fest(boolean isOpen) {
        this.mode = isOpen ? GameMode.OPEN : GameMode.CHALLENGE;
        this.scheduleURL = isOpen ? ScheduleApi.festOpen : ScheduleApi.festChallenge;
    }

    /**
     * ゲームモードの表示名を取得します。
     * @return ゲームモードの表示名
     */
    public String getMode() {
        return mode.getDisplayName();
    }

    /**
     * スケジュール取得用のURLを取得します。
     * @return スケジュール取得用URL
     */
    public String getScheduleURL() {
        return scheduleURL;
    }

    /**
     * フェスマッチのスケジュールをCLIで表示します。
     */
    public void showSchedule() {
        // JSONをURLから取得
        ArrayNode arrayNode = SplaScheduleUtils.getArrayNode(this.scheduleURL);

        if (arrayNode != null && arrayNode.isArray()) {
            // 各結果要素についてループ
            for (JsonNode jsonNode : arrayNode) {
                String startTime = jsonNode.get("start_time").asText();
                String endTime = jsonNode.get("end_time").asText();
                String ruleName = jsonNode.get("rule").get("name").asText();

                System.out.println("開始時間: " + startTime);
                System.out.println("終了時間: " + endTime);
                System.out.println("ルール名: " + ruleName);

                JsonNode stagesNode = jsonNode.get("stages");
                if (stagesNode != null && stagesNode.isArray()) {
                    // 各ステージについてループ
                    for (JsonNode stageNode : stagesNode) {
                        String stageName = stageNode.get("name").asText();
                        System.out.println("ステージ名: " + stageName);
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("結果情報が見つかりませんでした。");
        }
    }
}