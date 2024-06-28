package components.panel;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import components.label.*;
import schedule.*;

import javax.swing.*;
import java.util.*;

import static schedule.SplaSchedule.*;


public class FestPanel extends AbstractSchedulePanel {
    public FestPanel() {
        super();
    }

    @Override
    public void createPanel() {
        Fest scheduleChallenge = new Fest(false);
        Fest scheduleOpen = new Fest(true);

        ArrayNode arrayNodeChallenge = scheduleChallenge.getArrayNode();
        ArrayNode arrayNodeOpen = scheduleOpen.getArrayNode();

        // オープンとチャレンジの情報をペアとして表示
        Iterator<JsonNode> iteratorChallenge = arrayNodeChallenge.iterator();
        Iterator<JsonNode> iteratorOpen = arrayNodeOpen.iterator();

        while (iteratorChallenge.hasNext() && iteratorOpen.hasNext()) {
            JsonNode jsonNodeChallenge = iteratorChallenge.next();
            JsonNode jsonNodeOpen = iteratorOpen.next();

            setPanel(jsonNodeChallenge, scheduleChallenge.getMode(), true);
            setPanel(jsonNodeOpen, scheduleOpen.getMode(), false);
        }
    }

    private void setPanel(JsonNode jsonNode, String gameMode, boolean isFirstCalledMethod) {
        boolean isFest = jsonNode.get("is_fest").asBoolean();
        boolean isTricolor = jsonNode.get("tricolor_stage").asBoolean();

        if (!isFest) {
            return;
        }

        JLabel blankLine = new JLabel(" ");
        this.add(blankLine);

        JPanel tricolorPanel = new StagePanel();
        JPanel tricolorStagePanel = new StagePanel();
        JPanel tricolorStageSetPanel = new StageSetPanel();

        if (isFirstCalledMethod) {
            String startTime = jsonNode.get("start_time").asText();
            String endTime = jsonNode.get("end_time").asText();
            String formattedTimeFrame = getFormattedDateTime(startTime, endTime);

            JLabel timeFrameLabel = new TimeFrameLabel(formattedTimeFrame);

            this.add(timeFrameLabel);
        } else if (isTricolor) {
            String tricolor = "トリカラバトル開催中";
            String tricolorStage = jsonNode.get("tricolor_stage").get("name").asText();
            String imageURL = jsonNode.get("tricolor_stage").get("image").asText();

            JLabel tricolorLabel = new RuleLabel(tricolor);
            JLabel stageNameLabel = new StageNameLabel(tricolorStage);
            JLabel stageImageLabel = new StageImageLabel(imageURL);

            tricolorStagePanel.add(stageNameLabel);
            tricolorStagePanel.add(stageImageLabel);
            tricolorStageSetPanel.add(tricolorStagePanel);

            tricolorPanel.add(tricolorLabel);
            tricolorPanel.add(tricolorStageSetPanel);
        }

        this.add(tricolorPanel);

        gameMode = "(" + gameMode + ")";
        JLabel modeLabel = new RuleLabel(gameMode);

        this.add(modeLabel);

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
