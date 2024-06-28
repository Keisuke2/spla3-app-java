package schedule.components.panel;

import schedule.components.label.*;

public class L_RegularPanel extends AbstractLobbyPanel {
    public L_RegularPanel() {
        super();
    }

    @Override
    public void createPanel() {
        lobbyLabel = new LobbyLabel("レギュラーマッチ（ナワバリバトル）");
        add(lobbyLabel);
    }
}
