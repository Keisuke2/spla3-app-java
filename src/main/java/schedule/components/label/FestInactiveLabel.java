package schedule.components.label;

import java.awt.*;

/**
 * フェス非開催を表すラベルのクラスです。
 * このクラスは、現在フェスが開催されていないことを示すラベルを提供します。
 * {@link TextLabel} を継承しています。
 *
 * @see TextLabel
 */
public class FestInactiveLabel extends TextLabel {

    /**
     * コンストラクタ。
     * "現在フェスは開催されていません"というテキストを設定し、フォントとサイズを指定します。
     */
    public FestInactiveLabel() {
        super("現在フェスは開催されていません");
        setFont(new Font("HiraMaruProN-W4", Font.PLAIN, 14));
    }
}