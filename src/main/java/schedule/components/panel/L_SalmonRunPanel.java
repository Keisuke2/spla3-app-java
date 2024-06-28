package schedule.components.panel;

import schedule.components.label.*;

public class L_SalmonRunPanel extends AbstractLobbyPanel {
    public L_SalmonRunPanel() {
        super();
    }

    @Override
    public void createPanel() {
        lobbyLabel = new LobbyLabel("サーモンラン");
        add(lobbyLabel);
    }
}
