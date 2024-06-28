package schedule.components.panel;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import schedule.components.label.*;
import schedule.schedules.*;

import javax.swing.*;
import java.awt.*;

import static schedule.schedules.SplaScheduleUtils.*;

public class SalmonRunPanel extends AbstractSchedulePanel {
    public SalmonRunPanel() {
        super();
    }

    @Override
    public void createPanel() {
        SalmonRun salmonRun = new SalmonRun();
        ArrayNode arrayNode = salmonRun.getArrayNode();

        for (JsonNode jsonNode : arrayNode) {
            JLabel blankLine = new JLabel(" ");

            this.add(blankLine);

            String startTime = jsonNode.get("start_time").asText();
            String endTime = jsonNode.get("end_time").asText();
            String formattedTimeFrame = getFormattedDateTime(startTime, endTime);
            String bossName = jsonNode.get("boss").get("name").asText();
            String stageName = jsonNode.get("stage").get("name").asText() + "  " + bossName + "出現";
            String stageImage = jsonNode.get("stage").get("image").asText();

            JLabel timeFrameLabel = new TimeFrameLabel(formattedTimeFrame);
            JLabel stageNameLabel = new StageNameLabel(stageName);
            SRun_StageImageLabel stageImageLabel = new SRun_StageImageLabel(stageImage);

            JPanel stagePanel = new StagePanel();

            stagePanel.add(stageNameLabel);
            stagePanel.add(stageImageLabel);

            JPanel weaponsPanel = new JPanel();
            weaponsPanel.setOpaque(false);
            weaponsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

            for (JsonNode weaponNode : jsonNode.get("weapons")) {
                String weaponName = weaponNode.get("name").asText();
                String weaponImage = weaponNode.get("image").asText();

                JLabel weaponNameLabel = new WeaponNameLabel(weaponName);
                JLabel weaponImageLabel = new WeaponImageLabel(weaponImage);

                JPanel weaponPanel = new JPanel();
                weaponPanel.setOpaque(false);
                weaponPanel.setLayout(new BoxLayout(weaponPanel, BoxLayout.Y_AXIS));

                weaponPanel.add(weaponImageLabel);
                weaponPanel.add(weaponNameLabel);

                weaponsPanel.add(weaponPanel);
            }

            this.add(timeFrameLabel);
            this.add(stagePanel);
            this.add(weaponsPanel);
        }
    }
}
