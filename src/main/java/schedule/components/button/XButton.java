package schedule.components.button;

import schedule.data_src.*;

/**
 * Xマッチを表すボタンのコンポーネントを作成するクラスです。
 * このクラスは {@link RuleButton} を拡張し、Xマッチのイメージを持つボタンを提供します。
 *
 * @see RuleButton
 */
public class XButton extends RuleButton {

    /**
     * コンストラクタ。
     * Xマッチの画像をボタンに設定します。
     */
    public XButton() {
        super(ButtonImage.x);
    }
}