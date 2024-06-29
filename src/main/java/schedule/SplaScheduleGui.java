package schedule;

import schedule.components.button.*;
import schedule.components.panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SplaScheduleGui extends JFrame {
    private JButton regularButton;
    private JButton bankaraButton;
    private JButton xButton;
    private JButton eventButton;
    private JButton festButton;
    private JButton salmonRunButton;

    // 各パネルを保持するフィールドを追加
    private JPanel regularPanel;
    private JPanel bankaraPanel;
    private JPanel xPanel;
    private JPanel eventPanel;
    private JPanel festPanel;
    private JPanel salmonRunPanel;

    private JPanel l_regularPanel;
    private JPanel l_bankaraPanel;
    private JPanel l_xPanel;
    private JPanel l_eventPanel;
    private JPanel l_festPanel;
    private JPanel l_salmonRunPanel;
    private JPanel lobbyPanel;

    private JScrollPane scrollPane;

    public SplaScheduleGui() {
        super("Splatoon3 Schedule App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(520, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
//        getContentPane().setBackground(Color.LIGHT_GRAY);

        initButtons();
        initPanels();
        initScrollPane();
        addGuiComponents();
        setActionListenerToButton();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SplaScheduleGui().setVisible(true));
    }

    private void initButtons() {
        regularButton = new RegularButton();
        bankaraButton = new BankaraButton();
        xButton = new XButton();
        eventButton = new EventButton();
        festButton = new FestButton();
        salmonRunButton = new SalmonRunButton();
    }

    private void initPanels() {
        // すべてのパネルを初期化
        regularPanel = new RegularPanel();
        bankaraPanel = new BankaraPanel();
        xPanel = new XPanel();
        eventPanel = new EventPanel();
        festPanel = new FestPanel();
        salmonRunPanel = new SalmonRunPanel();

        l_regularPanel = new L_RegularPanel();
        l_bankaraPanel = new L_BankaraPanel();
        l_xPanel = new L_XPanel();
        l_eventPanel = new L_EventPanel();
        l_festPanel = new L_FestPanel();
        l_salmonRunPanel = new L_SalmonRunPanel();

        // 初期表示用
        lobbyPanel = l_regularPanel;
    }

    private void initScrollPane() {
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setViewportView(regularPanel);  // 初期表示用
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
    }

    private void addGuiComponents() {
        add(setButtonPanel(), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(lobbyPanel, BorderLayout.SOUTH);
    }

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

    private void setActionListenerToButton() {
        regularButton.addActionListener(this::onRegularButtonClick);
        bankaraButton.addActionListener(this::onBankaraButtonClick);
        xButton.addActionListener(this::onXButtonClick);
        eventButton.addActionListener(this::onEventButtonClick);
        festButton.addActionListener(this::onFestButtonClick);
        salmonRunButton.addActionListener(this::onSalmonRunButtonClick);
    }

    private void setScheduleAndLobbyPanel(JPanel schedulePanel, JPanel lobbyPanel) {
        scrollPane.setViewportView(schedulePanel);
        remove(this.lobbyPanel);
        this.lobbyPanel = lobbyPanel;
        add(this.lobbyPanel, BorderLayout.SOUTH);
        revalidate();
        repaint();
    }

    private void onRegularButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanel(regularPanel, l_regularPanel);
    }

    private void onBankaraButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanel(bankaraPanel, l_bankaraPanel);
    }

    private void onXButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanel(xPanel, l_xPanel);
    }

    private void onEventButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanel(eventPanel, l_eventPanel);
    }

    private void onFestButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanel(festPanel, l_festPanel);
    }

    private void onSalmonRunButtonClick(ActionEvent e) {
        setScheduleAndLobbyPanel(salmonRunPanel, l_salmonRunPanel);
    }
}
