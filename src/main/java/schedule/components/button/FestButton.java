package schedule.components.button;

import schedule.data_src.*;

/**
 * フェスマッチを表すボタンのコンポーネントを作成するクラスです。
 * このクラスは {@link RuleButton} を拡張し、フェスマッチのイメージを持つボタンを提供します。
 *
 * @see RuleButton
 */
public class FestButton extends RuleButton {

    /**
     * コンストラクタ。
     * フェスマッチの画像をボタンに設定します。
     */
    public FestButton() {
        super(ButtonImage.fest);
    }
}