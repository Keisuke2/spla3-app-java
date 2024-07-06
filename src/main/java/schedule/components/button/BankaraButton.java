package schedule.components.button;

import schedule.data_src.*;

/**
 * バンカラマッチを表すボタンのコンポーネントを作成するクラスです。
 * このクラスは {@link HeaderButton} を拡張し、バンカラマッチのイメージを持つボタンを提供します。
 *
 * @see HeaderButton
 */
public class BankaraButton extends HeaderButton {

    /**
     * コンストラクタ。
     * バンカラマッチの画像をボタンに設定します。
     */
    public BankaraButton() {
        super(ButtonImage.bankara);
    }
}