package components.panel;

import components.label.*;

public class L_BankaraPanel extends AbstractLobbyPanel {
    public L_BankaraPanel() {
        super();
    }

    @Override
    public void createPanel() {
        lobbyLabel = new LobbyLabel("バンカラマッチ");
        add(lobbyLabel);
    }
}
