package components.panel;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import components.label.*;
import schedule.*;

import javax.swing.*;

import static schedule.SplaSchedule.*;

public class RegularPanel extends AbstractSchedulePanel {

    public RegularPanel() {
        super();
    }

    @Override
    public void createPanel() {
        Regular regular = new Regular();
        ArrayNode arrayNode = regular.getArrayNode();

        for (JsonNode jsonNode : arrayNode) {
            // フェスマッチの時は表示しない
            if (jsonNode.get("is_fest").asBoolean()) {
                continue;
            }

            JLabel blankLine = new JLabel(" ");

            this.add(blankLine);

            String startTime = jsonNode.get("start_time").asText();
            String endTime = jsonNode.get("end_time").asText();
            String formattedTimeFrame = getFormattedDateTime(startTime, endTime);

            JLabel timeFrameLabel = new TimeFrameLabel(formattedTimeFrame);
            JLabel stageNameLabel;
            JLabel stageImageLabel;

            this.add(timeFrameLabel);

            JPanel stageSetPanel = new StageSetPanel();

            for (JsonNode stages : jsonNode.get("stages")) {
                String stageName = stages.get("name").asText();
                String imageURL = stages.get("image").asText();

                stageNameLabel = new StageNameLabel(stageName);
                stageImageLabel = new StageImageLabel(imageURL);

                JPanel stagePanel = new StagePanel();
                stagePanel.add(stageNameLabel);
                stagePanel.add(stageImageLabel);
                stageSetPanel.add(stagePanel);
            }
            this.add(stageSetPanel);
        }
    }
}
