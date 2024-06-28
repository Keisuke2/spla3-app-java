package schedule.components.panel;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import schedule.*;
import schedule.components.label.*;
import schedule.schedules.*;

import javax.swing.*;
import java.util.*;

import static schedule.SplaScheduleUtils.*;

public class EventPanel extends AbstractSchedulePanel {
    public EventPanel() {
        super();
    }

    @Override
    public void createPanel() {
        Event event = new Event();
        ArrayNode arrayNode = SplaScheduleUtils.getArrayNode(event.getScheduleURL());

        JPanel timeFramePanel = new JPanel();
        timeFramePanel.setOpaque(false);
        timeFramePanel.setLayout(new BoxLayout(timeFramePanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < Objects.requireNonNull(arrayNode).size(); i++) {
            JsonNode jsonNode = arrayNode.get(i);
            JsonNode nextJsonNode;

            String nextEventId = "";

            if (i + 1 < arrayNode.size()) {
                nextJsonNode = arrayNode.get(i + 1);

                nextEventId = nextJsonNode.get("event").get("id").asText();
            }

            String eventId = jsonNode.get("event").get("id").asText();
            String startTime = jsonNode.get("start_time").asText();
            String endTime = jsonNode.get("end_time").asText();
            String formattedTimeFrame = getFormattedDateTime(startTime, endTime);

            JLabel timeFrameLabel = new TimeFrameLabel(formattedTimeFrame);

            timeFramePanel.add(timeFrameLabel);

            if (!eventId.equals(nextEventId)) {
                JLabel blankLine = new JLabel(" ");
                this.add(blankLine);

                JPanel infoPanel = new JPanel();
                infoPanel.setOpaque(false);
                infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

                String name = jsonNode.get("event").get("name").asText();
                String desc = jsonNode.get("event").get("desc").asText();
                String rule = jsonNode.get("rule").get("name").asText();
                String stageName;
                String stageImage;

                JLabel nameLabel = new RuleLabel(name);
                JLabel descLabel = new RuleLabel(desc);
                JLabel ruleLabel = new RuleLabel(rule);

                infoPanel.add(nameLabel);
                infoPanel.add(descLabel);
                infoPanel.add(ruleLabel);

                JPanel stageSetPanel = new StageSetPanel();

                for (JsonNode stages : jsonNode.get("stages")) {
                    JPanel stagePanel = new StagePanel();

                    stageName = stages.get("name").asText();
                    stageImage = stages.get("image").asText();

                    JLabel stageNameLabel = new StageNameLabel(stageName);
                    JLabel stageImageLabel = new StageImageLabel(stageImage);

                    stagePanel.add(stageNameLabel);
                    stagePanel.add(stageImageLabel);

                    stageSetPanel.add(stagePanel);
                }

                this.add(infoPanel);
                this.add(stageSetPanel);
                this.add(timeFramePanel);

                timeFramePanel = new JPanel();
                timeFramePanel.setOpaque(false);
                timeFramePanel.setLayout(new BoxLayout(timeFramePanel, BoxLayout.Y_AXIS));
            }
        }
    }
}
