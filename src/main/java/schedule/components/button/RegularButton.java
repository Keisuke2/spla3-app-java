package schedule.components.button;

import schedule.data_src.*;

/**
 * レギュラーマッチを表すボタンのコンポーネントを作成するクラスです。
 * このクラスは {@link HeaderButton} を拡張し、レギュラーマッチのイメージを持つボタンを提供します。
 *
 * @see HeaderButton
 */
public class RegularButton extends HeaderButton {

    /**
     * コンストラクタ。
     * レギュラーマッチの画像をボタンに設定します。
     */
    public RegularButton() {
        super(ButtonIconPaths.regular);
    }
}