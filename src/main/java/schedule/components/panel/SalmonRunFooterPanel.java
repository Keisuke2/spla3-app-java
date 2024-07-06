package schedule.components.panel;

import schedule.components.label.*;

/**
 * サーモンランのフッターパネルを表します。
 * このクラスは {@link AbstractFooterPanel} を継承し、パネルの内容を設定します。
 *
 * @see AbstractFooterPanel
 */
public class SalmonRunFooterPanel extends AbstractFooterPanel {

    /**
     * コンストラクタ。
     * 親クラスのコンストラクタを呼び出します。
     */
    public SalmonRunFooterPanel() {
        super(new FooterLabel("サーモンラン"));
    }

    /**
     * パネルの内容を作成します。
     * "サーモンラン" のラベルを設定し、パネルに追加します。
     */
    @Override
    public void createPanel() {
        add(footerLabel);
    }
}