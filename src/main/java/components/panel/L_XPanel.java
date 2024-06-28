package components.panel;

import components.label.*;

public class L_XPanel extends AbstractLobbyPanel {
    public L_XPanel() {
        super();
    }

    @Override
    public void createPanel() {
        lobbyLabel = new LobbyLabel("Xマッチ");
        add(lobbyLabel);
    }
}
