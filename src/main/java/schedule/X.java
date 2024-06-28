package schedule;

import com.fasterxml.jackson.databind.*;
import data_src.*;

import java.io.*;

public class X extends SplaSchedule {

    public X() {
        scheduleURL = ScheduleApi.x;
    }

    @Override
    public void showSchedule() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // JSONをURLから取得
            JsonNode rootNode = objectMapper.readTree(getURL(scheduleURL));
            // "results"フィールドを取得
            JsonNode resultsNode = rootNode.get("results");
            if (resultsNode != null && resultsNode.isArray()) {
                // 各結果要素についてループ
                for (JsonNode resultNode : resultsNode) {
                    String startTime = resultNode.get("start_time").asText();
                    String endTime = resultNode.get("end_time").asText();
                    String ruleName = resultNode.get("rule").get("name").asText();

                    System.out.println("開始時間: " + startTime);
                    System.out.println("終了時間: " + endTime);
                    System.out.println("ルール名: " + ruleName);

                    JsonNode stagesNode = resultNode.get("stages");
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
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
