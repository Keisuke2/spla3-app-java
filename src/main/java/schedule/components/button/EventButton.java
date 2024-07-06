package schedule.components.button;

import schedule.data_src.*;

/**
 * イベントマッチを表すボタンのコンポーネントを作成するクラスです。
 * このクラスは {@link RuleButton} を拡張し、イベントマッチのイメージを持つボタンを提供します。
 *
 * @see RuleButton
 */
public class EventButton extends RuleButton {
    /**
     * コンストラクタ。
     * イベントマッチボタンの画像をボタンに設定します。
     */
    public EventButton() {
        super(ButtonImage.event);
    }
}