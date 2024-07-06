package schedule.components.panel;

import schedule.components.label.*;

/**
 * レギュラーマッチ（ナワバリバトル）のフッターパネルを表します。
 * このクラスは {@link AbstractFooterPanel} を継承し、パネルの内容を設定します。
 */
public class RegularFooterPanel extends AbstractFooterPanel {

    /**
     * コンストラクタ。
     * 親クラスのコンストラクタを呼び出します。
     */
    public RegularFooterPanel() {
        super(new FooterLabel("レギュラーマッチ（ナワバリバトル）"));
    }

    /**
     * パネルの内容を作成します。
     * "レギュラーマッチ（ナワバリバトル）" のラベルを設定し、パネルに追加します。
     */
    @Override
    public void createPanel() {
        add(footerLabel);
    }
}