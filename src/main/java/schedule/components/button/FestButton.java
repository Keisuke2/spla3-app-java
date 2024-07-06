package schedule.components.button;

import schedule.data_src.*;

/**
 * フェスマッチを表すボタンのコンポーネントを作成するクラスです。
 * このクラスは {@link HeaderButton} を拡張し、フェスマッチのイメージを持つボタンを提供します。
 *
 * @see HeaderButton
 */
public class FestButton extends HeaderButton {

    /**
     * コンストラクタ。
     * フェスマッチの画像をボタンに設定します。
     */
    public FestButton() {
        super(ButtonIconPaths.fest);
    }
}