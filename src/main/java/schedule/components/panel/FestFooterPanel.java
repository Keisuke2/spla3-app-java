package schedule.components.panel;

import schedule.components.label.*;

/**
 * フェスマッチのフッターパネルを表します。
 * このクラスは {@link AbstractFooterPanel} を継承し、パネルの内容を設定します。
 *
 * @see AbstractFooterPanel
 */
public class FestFooterPanel extends AbstractFooterPanel {

    /**
     * コンストラクタ。
     * 親クラスのコンストラクタを呼び出します。
     */
    public FestFooterPanel() {
        super(new FooterLabel("フェスマッチ"));
    }

    /**
     * パネルの内容を作成します。
     * "フェスマッチ" のラベルを設定し、パネルに追加します。
     */
    @Override
    public void createPanel() {
        add(footerLabel);
    }
}