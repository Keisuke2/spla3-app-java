package schedule.components.label;

import java.awt.*;

/**
 * フッターラベルを表すクラスです。
 * このクラスは、フッターに関連するテキストを表示するためのラベルを提供します。
 * {@link TextLabel} を継承しており、特定のフォント設定を適用します。
 *
 * @see TextLabel
 */
public class FooterLabel extends TextLabel {

    /**
     * コンストラクタ。
     * 指定されたテキストでラベルを初期化し、フッターに適したフォントに設定します。
     *
     * @param text 表示するテキスト
     */
    public FooterLabel(String text) {
        super(text);
        setFont(new Font("HiraMaruProN-W4", Font.PLAIN, 14));
    }
}