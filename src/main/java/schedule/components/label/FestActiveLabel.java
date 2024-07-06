package schedule.components.label;

import java.awt.*;

/**
 * フェス開催を表すラベルのクラスです。
 * このクラスは、フェスが開催中ということを示すラベルを提供します。
 * {@link TextLabel} を継承しています。
 *
 * @see TextLabel
 */
public class FestActiveLabel extends TextLabel {

    /**
     * コンストラクタ。
     * "現在フェスが開催中です"というテキストを設定し、フォントとサイズを指定します。
     */
    public FestActiveLabel() {
        super("現在フェスが開催中です");
        setFont(new Font("HiraMaruProN-W4", Font.PLAIN, 14));
    }
}