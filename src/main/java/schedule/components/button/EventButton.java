package schedule.components.button;

import schedule.data_src.*;

/**
 * イベントマッチを表すボタンのコンポーネントを作成するクラスです。
 * このクラスは {@link HeaderButton} を拡張し、イベントマッチのイメージを持つボタンを提供します。
 *
 * @see HeaderButton
 */
public class EventButton extends HeaderButton {
    /**
     * コンストラクタ。
     * イベントマッチボタンの画像をボタンに設定します。
     */
    public EventButton() {
        super(ButtonIconPaths.event);
    }
}