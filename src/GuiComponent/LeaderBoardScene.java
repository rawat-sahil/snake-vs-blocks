package GuiComponent;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *Scene that contain the leader board
 */
public class LeaderBoardScene extends Scene {
    Stage stage;
    MenuScene menuScene;
    LeaderBoard leaderBoard;
    boolean run=false;

    /**
     * @param leaderBoard
     */
    public LeaderBoardScene(LeaderBoard leaderBoard){
        super(leaderBoard,600,600);
        this.leaderBoard=leaderBoard;
    }

    /**
     * @param menuScene
     * @param stage
     */
    public void setScene(MenuScene menuScene, Stage stage){
        if(run==false){
            this.menuScene=menuScene;
            this.stage=stage;
            leaderBoard.setButtons(menuScene,stage);
            run=true;

        }
        else return;
    }

}
