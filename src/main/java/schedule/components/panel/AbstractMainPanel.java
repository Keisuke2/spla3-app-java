package schedule.components.panel;

import javax.swing.*;
import java.awt.*;

/**
 * スケジュールパネルの抽象基底クラスです。
 * このクラスは、各種スケジュール表示パネルの共通機能を提供します。
 * 具体的なスケジュールパネルクラスは、このクラスを継承して実装します。
 *
 * @see schedule.components.panel.BankaraMainPanel
 * @see javax.swing.JPanel
 */
public abstract class AbstractMainPanel extends JPanel {

    /**
     * コンストラクタ。
     * パネルのレイアウトを設定し、コンポーネントを生成します。
     * また、パネルを透明に設定します。
     *
     * @see #createPanel()
     * @see javax.swing.BoxLayout
     */
    public AbstractMainPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        createPanel();
        setOpaque(false);
    }

    /**
     * パネルのコンポーネントを生成するための抽象メソッド。
     * このメソッドは、具体的なサブクラスで実装する必要があります。
     * パネルに表示する具体的なコンポーネントの生成と配置を行います。
     */
    public abstract void createPanel();

    /**
     * パネルとその子コンポーネントの背景色を設定します。
     * このメソッドは、パネル自体の背景色を設定し、
     * さらに子コンポーネントのうち、JPanelインスタンスに対しても
     * 同じ背景色を適用します。
     *
     * @param color 設定する背景色
     */
    public void setBackgroundColor(Color color) {
        setBackground(color);
        // パネル内のコンポーネントにも同じ背景色を適用
        Component[] components = getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                component.setBackground(color);
            }
        }
    }
}