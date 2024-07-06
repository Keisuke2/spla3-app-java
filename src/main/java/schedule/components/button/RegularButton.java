package schedule.components.button;

import schedule.data_src.*;

/**
 * レギュラーマッチを表すボタンのコンポーネントを作成するクラスです。
 * このクラスは {@link RuleButton} を拡張し、レギュラーマッチのイメージを持つボタンを提供します。
 *
 * @see RuleButton
 */
public class RegularButton extends RuleButton {

    /**
     * コンストラクタ。
     * レギュラーマッチの画像をボタンに設定します。
     */
    public RegularButton() {
        super(ButtonImage.regular);
    }
}