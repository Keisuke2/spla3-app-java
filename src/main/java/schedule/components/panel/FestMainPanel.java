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
 * フェスマッチのスケジュール情報を表示するパネルクラスです。
 * このクラスは {@link AbstractMainPanel} を継承し、
 * フェスマッチのチャレンジとオープンのスケジュールを表示します。
 *
 * @see AbstractMainPanel
 */
public class FestMainPanel extends AbstractMainPanel {

    /**
     * コンストラクタ。
     * スーパークラスのコンストラクタを呼び出し、パネルの初期化を行います。
     */
    public FestMainPanel() {
        super();
    }

    /**
     * フェスマッチのスケジュールパネルを作成します。
     * チャレンジとオープンの両方のスケジュールを取得し、表示します。
     */
    @Override
    public void createPanel() {
        Fest festChallenge = new Fest(false);
        Fest festOpen = new Fest(true);

        ArrayNode arrayNodeChallenge = SplaScheduleUtils.getArrayNode(festChallenge.getScheduleURL());
        ArrayNode arrayNodeOpen = SplaScheduleUtils.getArrayNode(festOpen.getScheduleURL());

        // フェスマッチが全て非アクティブかどうかを判定
        boolean allFestivals = false;

        for (JsonNode jsonNode : Objects.requireNonNull(arrayNodeChallenge)) {
            if (jsonNode.get("is_fest").asBoolean()) {
                allFestivals = true;
                break;
            }
        }

        // フェスマッチが全て非アクティブの場合はメッセージを表示
        if (!allFestivals) {
            JLabel festMessageLabel = new FestInactiveLabel();
            this.add(festMessageLabel);
            return;
        }

        // オープンとチャレンジの情報をペアとして表示
        Iterator<JsonNode> iteratorChallenge = Objects.requireNonNull(arrayNodeChallenge).iterator();
        Iterator<JsonNode> iteratorOpen = Objects.requireNonNull(arrayNodeOpen).iterator();

        while (iteratorChallenge.hasNext() && iteratorOpen.hasNext()) {
            JsonNode jsonNodeChallenge = iteratorChallenge.next();
            JsonNode jsonNodeOpen = iteratorOpen.next();

            SchedulePanel schedulePanel = new SchedulePanel();

            setPanel(jsonNodeChallenge, festChallenge.getMode(), true, schedulePanel);
            setPanel(jsonNodeOpen, festOpen.getMode(), false, schedulePanel);

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
        boolean isTricolor = jsonNode.get("tricolor_stage").asBoolean();

        JLabel blankLine = new JLabel(" ");
        this.add(blankLine);

        JPanel tricolorPanel = new StagePanel();
        JPanel tricolorStagePanel = new StagePanel();
        JPanel tricolorStageSetPanel = new StageSetPanel();

        // 時間枠の設定（最初の呼び出し時のみ）
        if (isFirstCalledMethod) {
            String startTime = jsonNode.get("start_time").asText();
            String endTime = jsonNode.get("end_time").asText();
            String formattedTimeFrame = getFormattedDateTime(startTime, endTime);

            JLabel timeFrameLabel = new TimeFrameLabel(formattedTimeFrame);

            this.add(timeFrameLabel);
        }
//        else if (isTricolor) { // トリカラバトル開催時の場合
//            String tricolor = "トリカラバトル開催中";
//            String tricolorStage = jsonNode.get("tricolor_stage").get("name").asText();
//            String imageURL = jsonNode.get("tricolor_stage").get("image").asText();
//
//            JLabel tricolorLabel = new RuleLabel(tricolor);
//            JLabel stageNameLabel = new StageNameLabel(tricolorStage);
//            JLabel stageImageLabel = new StageImageLabel(imageURL);
//
//            tricolorStagePanel.add(stageNameLabel);
//            tricolorStagePanel.add(stageImageLabel);
//            tricolorStageSetPanel.add(tricolorStagePanel);
//
//            tricolorPanel.add(tricolorLabel);
//            tricolorPanel.add(tricolorStageSetPanel);
//        }
//
//        this.add(tricolorPanel);

        // ルールとゲームモードの設定
        gameMode = "(" + gameMode + ")";
        JLabel modeLabel = new RuleLabel(gameMode);

        this.add(modeLabel);

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

        this.add(stageSetPanel);
    }
}
