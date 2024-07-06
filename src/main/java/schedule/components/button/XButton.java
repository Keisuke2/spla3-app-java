package schedule.components.button;

import schedule.data_src.*;

/**
 * Xマッチを表すボタンのコンポーネントを作成するクラスです。
 * このクラスは {@link HeaderButton} を拡張し、Xマッチのイメージを持つボタンを提供します。
 *
 * @see HeaderButton
 */
public class XButton extends HeaderButton {

    /**
     * コンストラクタ。
     * Xマッチの画像をボタンに設定します。
     */
    public XButton() {
        super(ButtonIconPaths.x);
    }
}