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
 * バンカラマッチのスケジュール情報を表示するパネルクラスです。
 * このクラスは {@link AbstractMainPanel} を継承し、
 * バンカラマッチのチャレンジとオープンのスケジュールを表示します。
 *
 * @see AbstractMainPanel
 */
public class BankaraMainPanel extends AbstractMainPanel {

    /**
     * コンストラクタ。
     * スーパークラスのコンストラクタを呼び出し、パネルの初期化を行います。
     */
    public BankaraMainPanel() {
        super();
    }

    /**
     * バンカラマッチのスケジュールパネルを作成します。
     * チャレンジとオープンの両方のスケジュールを取得し、表示します。
     */
    @Override
    public void createPanel() {
        Bankara bankaraChallenge = new Bankara(false);
        Bankara bankaraOpen = new Bankara(true);

        ArrayNode arrayNodeChallenge = SplaScheduleUtils.getArrayNode(bankaraChallenge.getScheduleURL());
        ArrayNode arrayNodeOpen = SplaScheduleUtils.getArrayNode(bankaraOpen.getScheduleURL());

        Iterator<JsonNode> iteratorChallenge = Objects.requireNonNull(arrayNodeChallenge).iterator();
        Iterator<JsonNode> iteratorOpen = Objects.requireNonNull(arrayNodeOpen).iterator();

        // オープンとチャレンジの情報をペアとして表示
        while (iteratorChallenge.hasNext() && iteratorOpen.hasNext()) {
            JsonNode jsonNodeChallenge = iteratorChallenge.next();
            JsonNode jsonNodeOpen = iteratorOpen.next();

            SchedulePanel schedulePanel = new SchedulePanel();

            setPanel(jsonNodeChallenge, bankaraChallenge.getMode(), true, schedulePanel);
            setPanel(jsonNodeOpen, bankaraOpen.getMode(), false, schedulePanel);

            this.add(schedulePanel);
        }
    }

    /**
     * 個別のスケジュールパネルを設定します。
     * フェスマッチ時は表示せず、時間枠、ルール、ステージ情報を設定します。
     *
     * @param jsonNode            JsonNodeオブジェクト（スケジュール情報を含む）
     * @param gameMode            ゲームモード（チャレンジまたはオープン）
     * @param isFirstCalledMethod 最初に呼び出されたメソッドかどうか
     * @param schedulePanel       設定対象のスケジュールパネル
     */
    private void setPanel(JsonNode jsonNode, String gameMode, boolean isFirstCalledMethod, JPanel schedulePanel) {
        // フェスマッチの時は表示しない
        if (jsonNode.get("is_fest").asBoolean()) {
            return;
        }

        JLabel blankLine = new JLabel(" ");
        schedulePanel.add(blankLine);

        // 時間枠の設定（最初の呼び出し時のみ）
        if (isFirstCalledMethod) {
            String startTime = jsonNode.get("start_time").asText();
            String endTime = jsonNode.get("end_time").asText();
            String formattedTimeFrame = getFormattedDateTime(startTime, endTime);

            JLabel timeFrameLabel = new TimeFrameLabel(formattedTimeFrame);
            schedulePanel.add(timeFrameLabel);
        }

        // ルールとゲームモードの設定
        String rule = jsonNode.get("rule").get("name").asText();
        gameMode = "(" + gameMode + ")";

        JLabel ruleLabel = new RuleLabel(rule + gameMode);
        schedulePanel.add(ruleLabel);

        // ステージ情報の設定
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

        schedulePanel.add(stageSetPanel);
    }
}