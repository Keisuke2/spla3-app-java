package schedule.schedules;

import com.fasterxml.jackson.databind.*;
import schedule.data_src.*;

import java.io.*;

public class SalmonRun {
    private final String scheduleURL;

    public SalmonRun() {
        this.scheduleURL = ScheduleApi.salmonRun;
    }

    public String getScheduleURL() {
        return scheduleURL;
    }

    public void showSchedule() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // JSONをURLから取得
            JsonNode rootNode = objectMapper.readTree(SplaScheduleUtils.getURL(scheduleURL));
            // "results"フィールドを取得
            JsonNode resultsNode = rootNode.get("results");
            if (resultsNode != null && resultsNode.isArray()) {
                // 各結果要素についてループ
                for (JsonNode resultNode : resultsNode) {
                    String startTime = resultNode.get("start_time").asText();
                    String endTime = resultNode.get("end_time").asText();

                    System.out.println("開始時間: " + startTime);
                    System.out.println("終了時間: " + endTime);

                    JsonNode boss = resultNode.get("boss");
                    String bossName = boss.get("name").asText();
                    System.out.println("ボス名: " + bossName);

                    JsonNode stageNode = resultNode.get("stage");
                    String stageName = stageNode.get("name").asText();
                    System.out.println("ステージ名: " + stageName);

                    JsonNode weaponsNode = resultNode.get("weapons");

                    for (JsonNode weaponNode : weaponsNode) {
                        String weaponName = weaponNode.get("name").asText();
                        System.out.println("支給武器: " + weaponName);
                    }

                    System.out.println();
                }
            } else {
                System.out.println("結果情報が見つかりませんでした。");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
