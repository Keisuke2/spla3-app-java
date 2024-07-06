package schedule.components.button;

import schedule.data_src.*;

/**
 * バンカラマッチを表すボタンのコンポーネントを作成するクラスです。
 * このクラスは {@link RuleButton} を拡張し、バンカラマッチのイメージを持つボタンを提供します。
 *
 * @see RuleButton
 */
public class BankaraButton extends RuleButton {

    /**
     * コンストラクタ。
     * バンカラマッチの画像をボタンに設定します。
     */
    public BankaraButton() {
        super(ButtonImage.bankara);
    }
}