package schedule.components.panel;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import schedule.*;
import schedule.components.label.*;
import schedule.schedules.*;

import javax.swing.*;
import java.util.*;

import static schedule.SplaScheduleUtils.*;

public class XPanel extends AbstractSchedulePanel {
    public XPanel() {
        super();
    }

    @Override
    public void createPanel() {
        X x = new X();
        ArrayNode arrayNode = SplaScheduleUtils.getArrayNode(x.getScheduleURL());

        for (JsonNode jsonNode : Objects.requireNonNull(arrayNode)) {
            // フェスマッチの時は表示しない
            if (jsonNode.get("is_fest").asBoolean()) {
                continue;
            }

            JLabel blankLine = new JLabel(" ");

            this.add(blankLine);

            String startTime = jsonNode.get("start_time").asText();
            String endTime = jsonNode.get("end_time").asText();
            String formattedTimeFrame = getFormattedDateTime(startTime, endTime);
            String rule = jsonNode.get("rule").get("name").asText();

            JLabel timeFrameLabel = new TimeFrameLabel(formattedTimeFrame);
            JLabel stageNameLabel;
            JLabel stageImageLabel;
            JLabel ruleLabel = new RuleLabel(rule);

            this.add(timeFrameLabel);
            this.add(ruleLabel);

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
