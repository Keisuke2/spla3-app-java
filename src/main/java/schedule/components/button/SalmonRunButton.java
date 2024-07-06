package schedule.components.button;

import schedule.data_src.*;

/**
 * サーモンランを表すボタンのコンポーネントを作成するクラスです。
 * このクラスは {@link HeaderButton} を拡張し、サーモンランのイメージを持つボタンを提供します。
 *
 * @see HeaderButton
 */
public class SalmonRunButton extends HeaderButton {

    /**
     * コンストラクタ。
     * サーモンランの画像をボタンに設定します。
     */
    public SalmonRunButton() {
        super(ButtonImage.salmonrun);
    }
}