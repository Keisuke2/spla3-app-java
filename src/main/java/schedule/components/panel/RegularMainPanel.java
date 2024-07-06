package schedule.components.panel;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import schedule.*;
import schedule.components.label.*;
import schedule.schedules.*;

import javax.swing.*;
import java.util.*;

import static schedule.SplaScheduleUtils.*;

/**
 * レギュラーマッチのスケジュール情報を表示するパネルクラスです。
 * このクラスは {@link AbstractMainPanel} を継承し、
 * レギュラーマッチのスケジュールを表示します。
 *
 * @see AbstractMainPanel
 */
public class RegularMainPanel extends AbstractMainPanel {

    /**
     * コンストラクタ。
     * スーパークラスのコンストラクタを呼び出し、パネルの初期化を行います。
     */
    public RegularMainPanel() {
        super();
    }

    /**
     * レギュラーマッチのスケジュールパネルを作成します。
     */
    @Override
    public void createPanel() {
        Regular regular = new Regular();
        ArrayNode arrayNode = SplaScheduleUtils.getArrayNode(regular.getScheduleURL());

        for (JsonNode jsonNode : Objects.requireNonNull(arrayNode)) {
            // フェスマッチの時は表示しない
            if (jsonNode.get("is_fest").asBoolean()) {
                continue;
            }
            JLabel blankLine = new JLabel(" ");

            SchedulePanel schedulePanel = new SchedulePanel();
            schedulePanel.add(blankLine);

            String startTime = jsonNode.get("start_time").asText();
            String endTime = jsonNode.get("end_time").asText();
            String formattedTimeFrame = getFormattedDateTime(startTime, endTime);

            JLabel timeFrameLabel = new TimeFrameLabel(formattedTimeFrame);
            JLabel stageNameLabel;
            JLabel stageImageLabel;

            schedulePanel.add(timeFrameLabel);

            // ステージ情報の設定
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
            schedulePanel.add(stageSetPanel);
            this.add(schedulePanel);
        }
    }
}
