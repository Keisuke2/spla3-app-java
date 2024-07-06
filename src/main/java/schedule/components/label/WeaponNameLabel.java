package schedule.components.label;

import java.awt.*;

/**
 * サーモンランの武器名を表示するラベルのクラスです。
 * このクラスは {@link TextLabel} を継承し、武器名用の特定のフォント設定を適用するラベルを提供します。
 *
 * @see TextLabel
 */
public class WeaponNameLabel extends TextLabel {

    /**
     * コンストラクタ。
     * 指定されたテキストを持つWeaponNameLabelを作成します。
     *
     * @param text ラベルに表示する武器名
     */
    public WeaponNameLabel(String text) {
        super(text);
        // フォントを"HiraMaruProN-W4"、スタイルをPLAIN、サイズを10に設定します。
        setFont(new Font("HiraMaruProN-W4", Font.PLAIN, 10));
    }
}