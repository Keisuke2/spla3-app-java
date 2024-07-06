package schedule.components.panel;

import schedule.components.label.*;

/**
 * Xマッチのフッターパネルを表します。
 * このクラスは {@link AbstractFooterPanel} を継承し、パネルの内容を設定します。
 */
public class XFooterPanel extends AbstractFooterPanel {

    /**
     * コンストラクタ。
     * 親クラスのコンストラクタを呼び出します。
     */
    public XFooterPanel() {
        super(new FooterLabel("Xマッチ"));
    }

    /**
     * パネルの内容を作成します。
     * "Xマッチ" のラベルを設定し、パネルに追加します。
     */
    @Override
    public void createPanel() {
        add(footerLabel);
    }
}