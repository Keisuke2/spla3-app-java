package schedule.components.label;

import java.awt.*;

/**
 * 時間枠を表すラベルを提供します。
 * このクラスは {@link TextLabel} を継承し、特定のフォント設定を適用するラベルを提供します。
 *
 * @see TextLabel
 */
public class TimeFrameLabel extends TextLabel {

    /**
     * コンストラクタ。
     * 指定されたテキストを持つTimeFrameLabelを作成します。
     *
     * @param text ラベルに表示するテキスト
     */
    public TimeFrameLabel(String text) {
        super(text);
        // フォントを"HiraMaruProN-W4"、スタイルをPLAIN、サイズを16に設定します。
        setFont(new Font("HiraMaruProN-W4", Font.PLAIN, 16));
    }
}