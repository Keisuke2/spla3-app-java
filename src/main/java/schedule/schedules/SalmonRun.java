package schedule.schedules;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import schedule.*;
import schedule.data_src.*;

/**
 * サーモンランのスケジュールを管理するクラスです。
 */
public class SalmonRun {
    private final String scheduleURL;  // スケジュール取得用URL

    /**
     * サーモンランのインスタンスを作成します。
     */
    public SalmonRun() {
        this.scheduleURL = ScheduleApiEndpoints.salmonRun;
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
     * サーモンランのスケジュールを表示します。
     */
    public void showSchedule() {
        // JSONをURLから取得
        ArrayNode arrayNode = SplaScheduleUtils.getArrayNode(this.scheduleURL);

        if (arrayNode != null && arrayNode.isArray()) {
            // 各結果要素についてループ
            for (JsonNode jsonNode : arrayNode) {
                String startTime = jsonNode.get("start_time").asText();
                String endTime = jsonNode.get("end_time").asText();

                System.out.println("開始時間: " + startTime);
                System.out.println("終了時間: " + endTime);

                JsonNode boss = jsonNode.get("boss");
                String bossName = boss.get("name").asText();
                System.out.println("ボス名: " + bossName);

                JsonNode stageNode = jsonNode.get("stage");
                String stageName = stageNode.get("name").asText();
                System.out.println("ステージ名: " + stageName);

                JsonNode weaponsNode = jsonNode.get("weapons");

                for (JsonNode weaponNode : weaponsNode) {
                    String weaponName = weaponNode.get("name").asText();
                    System.out.println("支給武器: " + weaponName);
                }

                System.out.println();
            }
        } else {
            System.out.println("結果情報が見つかりませんでした。");
        }
    }
}