package schedule.components.label;

import java.awt.*;

/**
 * ステージ名を表示するラベルのクラスです。
 * このクラスは {@link TextLabel} を継承し、特定のフォント設定を適用するラベルを提供します。
 *
 * @see TextLabel
 */
public class StageNameLabel extends TextLabel {

    /**
     * コンストラクタ。
     * 指定されたテキストを持つStageNameLabelを作成します。
     *
     * @param text ラベルに表示するテキスト
     */
    public StageNameLabel(String text) {
        super(text);
        // フォントを"HiraMaruProN-W4"、スタイルをPLAIN、サイズを14に設定します。
        setFont(new Font("HiraMaruProN-W4", Font.PLAIN, 14));
    }
}