package schedule.components.panel;

import javax.swing.*;
import java.awt.*;

/**
 * フッターパネルの抽象クラスです。
 * このクラスは {@link JPanel} を拡張し、フッターパネルの基本的な構造を定義します。
 * 具体的なパネルの内容はサブクラスで実装します。
 *
 * @see JPanel
 */
public abstract class AbstractFooterPanel extends JPanel {
    protected JLabel footerLabel;

    /**
     * コンストラクタ。
     * パネルのレイアウトを設定し、フッターラベルを中央揃えにし、パネルを透明に設定します。
     * さらに、createPanelメソッドを呼び出して、具体的なパネルの内容を作成します。
     */
    public AbstractFooterPanel(JLabel footerLabel) {
        this.footerLabel = footerLabel;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setOpaque(false);
        createPanel();
    }

    /**
     * パネルの内容を作成するための抽象メソッドです。
     * このメソッドはサブクラスで具体的な実装を行う必要があります。
     */
    public abstract void createPanel();
}