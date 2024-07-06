package schedule.components.panel;

import schedule.components.label.*;

/**
 * バンカラマッチのフッターパネルを表します。
 * このクラスは {@link AbstractFooterPanel} を継承し、パネルの内容を設定します。
 */
public class BankaraFooterPanel extends AbstractFooterPanel {

    /**
     * コンストラクタ。
     * 親クラスのコンストラクタを呼び出します。
     */
    public BankaraFooterPanel() {
        super(new FooterLabel("バンカラマッチ"));
//        footerLabel = new FooterLabel("バンカラマッチ");
    }

    /**
     * パネルの内容を作成します。
     * "バンカラマッチ" のラベルを設定し、パネルに追加します。
     */
    @Override
    public void createPanel() {
        add(footerLabel);
    }
}