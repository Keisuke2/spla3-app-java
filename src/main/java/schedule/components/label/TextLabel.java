package schedule.components.label;

import javax.swing.*;
import java.awt.*;

/**
 * このクラスは {@link JLabel} を継承し、中央揃えのテキストラベルを提供します。
 *
 * @see JLabel
 */
public class TextLabel extends JLabel {

    /**
     * コンストラクタ。
     * 指定されたテキストを持つTextLabelを作成します。
     *
     * @param text ラベルに表示するテキスト
     */
    public TextLabel(String text) {
        super(text);
        // ラベルを水平方向の中央に配置します。
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}