package schedule;

import schedule.components.button.*;
import schedule.components.panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Splatoon 3 スケジュールアプリケーションのメインGUIを表すクラスです。
 * このクラスは {@link JFrame} を拡張し、パネルとボタンを含むアプリケーションのメインウィンドウを初期化します。
 */
public class SplaScheduleGui extends JFrame {
    // 各スケジュールの選択用ボタン（ヘッダー）
    private JButton regularButton;
    private JButton bankaraButton;
    private JButton xButton;
    private JButton eventButton;
    private JButton festButton;
    private JButton salmonRunButton;

    // 各スケジュールの表示用（メイン）パネル
    private JPanel regularMainPanel;
    private JPanel bankaraMainPanel;
    private JPanel xMainPanel;
    private JPanel eventMainPanel;
    private JPanel festMainPanel;
    private JPanel salmonRunMainPanel;

    // 各スケジュールのフッターパネル
    private JPanel regularFooterPanel;
    private JPanel bankaraFooterPanel;
    private JPanel xFooterPanel;
    private JPanel eventFooterPanel;
    private JPanel festFooterPanel;
    private JPanel salmonRunFooterPanel;
    private JPanel footerPanel;

    // スクロールパネル
    private JScrollPane scrollPane;

    /**
     * コンストラクタ。
     * Splatoon 3 スケジュールアプリケーションのメインGUIフレームを構築します。
     * フレームを初期化し、そのプロパティを設定し、コンポーネントを配置します。
     */
    public SplaScheduleGui() {
        super("Splatoon3 Schedule App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(520, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        // 各ボタンとパネルを初期化
        initButtons();
        initPanels();
        initScrollPane();

        // GUIコンポーネントをフレームに追加
        addGuiComponents();

        // ボタンにアクションリスナーを設定
        setActionListenerToButton();
    }

    /**
     * アプリケーションのエントリーポイントです。
     *
     * @param args コマンドライン引数（使用されません）
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SplaScheduleGui().setVisible(true));
    }

    /**
     * GUIで使用するボタンを初期化します。
     * 各ボタンはSplatoon 3の異なるゲームモードやイベントに対応します。
     */
    private void initButtons() {
        regularButton = new RegularButton();
        bankaraButton = new BankaraButton();
        xButton = new XButton();
        eventButton = new EventButton();
        festButton = new FestButton();
        salmonRunButton = new SalmonRunButton();
    }

    /**
     * 各ゲームモードやイベントのスケジュールを表示するパネルを初期化します。
     */
    private void initPanels() {
        // 各メインパネルを初期化
        regularMainPanel = new RegularMainPanel();
        bankaraMainPanel = new BankaraMainPanel();
        xMainPanel = new XMainPanel();
        eventMainPanel = new EventMainPanel();
        festMainPanel = new FestMainPanel();
        salmonRunMainPanel = new SalmonRunMainPanel();

        // 各フッターパネルを初期化
        regularFooterPanel = new RegularFooterPanel();
        bankaraFooterPanel = new BankaraFooterPanel();
        xFooterPanel = new XFooterPanel();
        eventFooterPanel = new EventFooterPanel();
        festFooterPanel = new FestFooterPanel();
        salmonRunFooterPanel = new SalmonRunFooterPanel();

        // 初期表示用のフッターパネル
        footerPanel = regularFooterPanel;
    }

    /**
     * スクロールパネルを初期化します。
     * スクロールパネルには選択されたゲームモードのスケジュールが表示されます。
     */
    private void initScrollPane() {
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setViewportView(regularMainPanel); // 初期表示用
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
    }

    /**
     * GUIコンポーネントをメインフレームに追加します。
     * レイアウトを設定し、パネルとボタンをフレームに追加します。
     */
    private void addGuiComponents() {
        add(setButtonPanel(), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
    }

    /**
     * ボタン用のパネルを設定し、ボタンを追加します。
     *
     * @return ボタンパネル。
     */
    private JPanel setButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setOpaque(false);
        buttonPanel.add(regularButton);
        buttonPanel.add(bankaraButton);
        buttonPanel.add(xButton);
        buttonPanel.add(eventButton);
        buttonPanel.add(festButton);
        buttonPanel.add(salmonRunButton);
        return buttonPanel;
    }

    /**
     * 各ボタンにアクションリスナーを設定します。
     * 各ボタンが押されたときに、選択されたゲームモードに基づいて表示されるスケジュールを更新します。
     */
    private void setActionListenerToButton() {
        regularButton.addActionListener(this::onRegularButtonClick);
        bankaraButton.addActionListener(this::onBankaraButtonClick);
        xButton.addActionListener(this::onXButtonClick);
        eventButton.addActionListener(this::onEventButtonClick);
        festButton.addActionListener(this::onFestButtonClick);
        salmonRunButton.addActionListener(this::onSalmonRunButtonClick);
    }

    /**
     * 選択されたゲームモードに基づいてメインパネルとフッターパネルを更新します。
     *
     * @param mainPanel   表示するメインパネル
     * @param footerPanel 表示するフッターパネル
     */
    private void setScheduleAndLobbyPanel(JPanel mainPanel, JPanel footerPanel) {
        scrollPane.setViewportView(mainPanel);
        remove(this.footerPanel);
        this.footerPanel = footerPanel;
        add(this.footerPanel, BorderLayout.SOUTH);
        revalidate();
        repaint();
    }

    /**
     * レギュラーマッチボタンがクリックされたときの処理を行います。
     * レギュラーマッチのメインパネルとフッターパネルを表示します。
     *
     * @param e アクションイベント
     */
    private void onRegularButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanel(regularMainPanel, regularFooterPanel);
    }

    /**
     * バンカラマッチボタンがクリックされたときの処理を行います。
     * バンカラマッチのメインパネルとフッターパネルを表示します。
     *
     * @param e アクションイベント
     */
    private void onBankaraButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanel(bankaraMainPanel, bankaraFooterPanel);
    }

    /**
     * Xマッチボタンがクリックされたときの処理を行います。
     * Xマッチのメインパネルとフッターパネルを表示します。
     *
     * @param e アクションイベント
     */
    private void onXButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanel(xMainPanel, xFooterPanel);
    }

    /**
     * イベントマッチボタンがクリックされたときの処理を行います。
     * イベントマッチのメインパネルとフッターパネルを表示します。
     *
     * @param e アクションイベント
     */
    private void onEventButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanel(eventMainPanel, eventFooterPanel);
    }

    /**
     * フェスマッチボタンがクリックされたときの処理を行います。
     * フェスマッチのメインパネルとフッターパネルを表示します。
     *
     * @param e アクションイベント
     */
    private void onFestButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanel(festMainPanel, festFooterPanel);
    }

    /**
     * サーモンランボタンがクリックされたときの処理を行います。
     * サーモンランのメインパネルとフッターパネルを表示します。
     *
     * @param e アクションイベント
     */
    private void onSalmonRunButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanel(salmonRunMainPanel, salmonRunFooterPanel);
    }
}