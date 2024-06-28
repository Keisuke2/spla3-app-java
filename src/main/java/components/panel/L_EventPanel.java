package components.panel;

import components.label.*;

public class L_EventPanel extends AbstractLobbyPanel {
    public L_EventPanel() {
        super();
    }

    @Override
    public void createPanel() {
        lobbyLabel = new LobbyLabel("イベントマッチ");
        add(lobbyLabel);
    }
}
