package schedule.components.button;

import schedule.data_src.*;

/**
 * サーモンランを表すボタンのコンポーネントを作成するクラスです。
 * このクラスは {@link RuleButton} を拡張し、サーモンランのイメージを持つボタンを提供します。
 *
 * @see RuleButton
 */
public class SalmonRunButton extends RuleButton {

    /**
     * コンストラクタ。
     * サーモンランの画像をボタンに設定します。
     */
    public SalmonRunButton() {
        super(ButtonImage.salmonrun);
    }
}