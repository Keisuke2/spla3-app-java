package components.panel;

import components.label.*;

public class L_FestPanel extends AbstractLobbyPanel {
    public L_FestPanel() {
        super();
    }

    @Override
    public void createPanel() {
        lobbyLabel = new LobbyLabel("フェスマッチ");
        add(lobbyLabel);
    }
}
