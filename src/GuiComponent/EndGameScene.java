package GuiComponent;

import javafx.scene.Scene;

/**
 *Scene after the game ends
 */
public class EndGameScene extends Scene {
    /**
     * @param Score
     */
    public EndGameScene(int Score) {
        super(new EndGameMenu(Score),600,600);

    }
}
