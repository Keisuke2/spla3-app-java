package schedule.components.panel;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import schedule.components.label.*;
import schedule.schedules.*;

import javax.swing.*;
import java.util.*;

import static schedule.schedules.SplaScheduleUtils.*;

public class BankaraPanel extends AbstractSchedulePanel {
    public BankaraPanel() {
        super();
    }

    @Override
    public void createPanel() {
        Bankara bankaraChallenge = new Bankara(false);
        Bankara bankaraOpen = new Bankara(true);

        ArrayNode arrayNodeChallenge = bankaraChallenge.getArrayNode();
        ArrayNode arrayNodeOpen = bankaraOpen.getArrayNode();

        // オープンとチャレンジの情報をペアとして表示
        Iterator<JsonNode> iteratorChallenge = arrayNodeChallenge.iterator();
        Iterator<JsonNode> iteratorOpen = arrayNodeOpen.iterator();

        while (iteratorChallenge.hasNext() && iteratorOpen.hasNext()) {
            JsonNode jsonNodeChallenge = iteratorChallenge.next();
            JsonNode jsonNodeOpen = iteratorOpen.next();

            setPanel(jsonNodeChallenge, bankaraChallenge.getMode(), true);
            setPanel(jsonNodeOpen, bankaraOpen.getMode(), false);
        }
    }

    private void setPanel(JsonNode jsonNode, String gameMode, boolean isFirstCalledMethod) {
        // フェスマッチの時は表示しない
        if (jsonNode.get("is_fest").asBoolean()) {
            return;
        }

        JLabel blankLine = new JLabel(" ");
        this.add(blankLine);

        if (isFirstCalledMethod) {
            String startTime = jsonNode.get("start_time").asText();
            String endTime = jsonNode.get("end_time").asText();
            String formattedTimeFrame = getFormattedDateTime(startTime, endTime);

            JLabel timeFrameLabel = new TimeFrameLabel(formattedTimeFrame);

            this.add(timeFrameLabel);
        }

        String rule = jsonNode.get("rule").get("name").asText();
        gameMode = "(" + gameMode + ")";

        JLabel ruleLabel = new RuleLabel(rule + gameMode);

        this.add(ruleLabel);

        JPanel stageSetPanel = new StageSetPanel();

        for (JsonNode stageNode : jsonNode.get("stages")) {
            String stageName = stageNode.get("name").asText();
            String imageURL = stageNode.get("image").asText();

            JLabel stageNameLabel = new StageNameLabel(stageName);
            JLabel stageImageLabel = new StageImageLabel(imageURL);

            JPanel stagePanel = new StagePanel();
            stagePanel.add(stageNameLabel);
            stagePanel.add(stageImageLabel);
            stageSetPanel.add(stagePanel);
        }

        this.add(stageSetPanel);
    }
}
