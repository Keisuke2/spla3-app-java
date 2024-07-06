package schedule.schedules;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import schedule.*;
import schedule.data_src.*;

/**
 * レギュラーマッチのスケジュールを管理するクラスです。
 */
public class Regular {
    private final String scheduleURL;  // スケジュール取得用URL

    /**
     * レギュラーマッチのインスタンスを作成します。
     */
    public Regular() {
        this.scheduleURL = ScheduleApi.regular;
    }

    /**
     * スケジュール取得用のURLを取得します。
     *
     * @return スケジュール取得用URL
     */
    public String getScheduleURL() {
        return scheduleURL;
    }

    /**
     * レギュラーマッチのスケジュールを表示します。
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