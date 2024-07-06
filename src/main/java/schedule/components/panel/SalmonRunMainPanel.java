package schedule.components.panel;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import schedule.*;
import schedule.components.label.*;
import schedule.schedules.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import static schedule.SplaScheduleUtils.*;

/**
 * サーモンランのスケジュール情報を表示するパネルクラスです。
 * このクラスは {@link AbstractMainPanel} を継承し、
 * サーモンランのスケジュールを表示します。
 *
 * @see AbstractMainPanel
 */
public class SalmonRunMainPanel extends AbstractMainPanel {

    /**
     * コンストラクタ。
     * スーパークラスのコンストラクタを呼び出し、パネルの初期化を行います。
     */
    public SalmonRunMainPanel() {
        super();
    }

    /**
     * サーモンランのスケジュールパネルを作成します。
     */
    @Override
    public void createPanel() {
        SalmonRun salmonRun = new SalmonRun();
        ArrayNode arrayNode = SplaScheduleUtils.getArrayNode(salmonRun.getScheduleURL());

        for (JsonNode jsonNode : Objects.requireNonNull(arrayNode)) {
            JLabel blankLine = new JLabel(" ");

            SchedulePanel schedulePanel = new SchedulePanel();
            schedulePanel.add(blankLine);

            String startTime = jsonNode.get("start_time").asText();
            String endTime = jsonNode.get("end_time").asText();
            String formattedTimeFrame = getFormattedDateTime(startTime, endTime);
            String bossName = jsonNode.get("boss").get("name").asText();
            String stageName = jsonNode.get("stage").get("name").asText() + "  " + bossName + "出現";
            String stageImage = jsonNode.get("stage").get("image").asText();

            JLabel timeFrameLabel = new TimeFrameLabel(formattedTimeFrame);
            JLabel stageNameLabel = new StageNameLabel(stageName);
            SRun_StageImageLabel stageImageLabel = new SRun_StageImageLabel(stageImage);

            // ステージ情報の設定
            JPanel stagePanel = new StagePanel();

            stagePanel.add(stageNameLabel);
            stagePanel.add(stageImageLabel);

            // 武器情報の設定
            JPanel weaponsPanel = new JPanel();
            weaponsPanel.setOpaque(false);
            weaponsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));

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

            schedulePanel.add(timeFrameLabel);
            schedulePanel.add(stagePanel);
            schedulePanel.add(weaponsPanel);
            this.add(schedulePanel);
        }
    }
}
