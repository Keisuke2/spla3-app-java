package schedule.components.panel;

import schedule.components.label.*;

/**
 * イベントマッチのフッターパネルを表します。
 * このクラスは {@link AbstractFooterPanel} を継承し、パネルの内容を設定します。
 *
 * @see AbstractFooterPanel
 */
public class EventFooterPanel extends AbstractFooterPanel {

    /**
     * コンストラクタ。
     * 親クラスのコンストラクタを呼び出します。
     */
    public EventFooterPanel() {
        super(new FooterLabel("イベントマッチ"));
    }

    /**
     * パネルの内容を作成します。
     * "イベントマッチ" のラベルを設定し、パネルに追加します。
     */
    @Override
    public void createPanel() {
        add(footerLabel);
    }
}